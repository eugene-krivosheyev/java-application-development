package com.acme.dbo.txlog;

import java.util.Objects;

import static com.acme.dbo.txlog.LoggerTypes.BYTE_TYPE;
import static com.acme.dbo.txlog.LoggerTypes.INT_TYPE;
import static com.acme.dbo.txlog.LoggerTypes.STRING_TYPE;

public class Facade {

    public static boolean isDecorated = false;
    private static LoggerTypes previousType;

    private static String stringState = "";
    private static int intState;
    private static byte byteState;
    private static int stringStateCount;

    public static void log(int message) {
        write(String.valueOf(message), INT_TYPE);
    }

    public static void log(byte message) {
        write(String.valueOf(message), BYTE_TYPE);
    }

    public static void log(boolean message){
        write(String.valueOf(message), LoggerTypes.BOOLEAN_TYPE);
    }

    public static void log(Object message){
        write(String.valueOf(message), LoggerTypes.OBJECT_TYPE);
    }

    public static void log(char message){
        write(String.valueOf(message), LoggerTypes.CHAR_TYPE);
    }

    public static void log(String message){
        write(String.valueOf(message), STRING_TYPE);
    }

    private static void write(String payLoad, LoggerTypes operationType) {
        checkBuffer(operationType);

        if (!operationType.isBuffered()){
            System.out.println(decorate(payLoad, operationType));
        } else {
            accumulate(payLoad, operationType);
        }
        previousType = operationType;
    }

    private static void checkBuffer(LoggerTypes newType) {
        if (Objects.isNull(previousType)){
            previousType = newType;
        } else if (!newType.equals(previousType)){
            flush();
        }
    }

    private static void accumulate(String payLoad, LoggerTypes operationType) {
        switch (operationType){
            case INT_TYPE:
                int intPayload = Integer.valueOf(payLoad);
                if (intPayload > Integer.MAX_VALUE - intState){
                    flush();
                }
                intState += intPayload;
                break;
            case BYTE_TYPE:
                int bytePayload = Byte.valueOf(payLoad);
                if (bytePayload > Byte.MAX_VALUE - byteState){
                    flush();
                }
                byteState += bytePayload;
                break;
            case STRING_TYPE:
                if (stringState.equals("")){
                    stringState = payLoad;
                }
                else if (stringState.equals(payLoad)){
                    stringStateCount ++;
                } else {
                    flush();
                    stringState = payLoad;
                }
                break;
        }
    }

    public static void flush() {
        switch (previousType){
            case STRING_TYPE:
                stringState = decorate(stringState, STRING_TYPE);
                if (stringStateCount > 0){
                    System.out.println(String.format("%s (x%d)", stringState, ++ stringStateCount));
                } else {
                    System.out.println(stringState);
                }
                stringStateCount = 0;
                stringState = "";
                break;
            case INT_TYPE:
                System.out.println(decorate(intState, INT_TYPE));
                intState = 0;
                break;
            case BYTE_TYPE:
                System.out.println(decorate(byteState, BYTE_TYPE));
                byteState = 0;
        }
    }

    private static String decorate(Object payLoad, LoggerTypes type){
        String stringPayLoad = String.valueOf(payLoad);
        if (isDecorated){
            return type.getDecoratePrefix() + ": " + stringPayLoad;
        } else {
            return stringPayLoad;
        }
    }

    public static void clean(){
        previousType = null;
    }

}