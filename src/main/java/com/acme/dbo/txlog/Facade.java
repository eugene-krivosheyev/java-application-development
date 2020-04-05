package com.acme.dbo.txlog;

import java.util.Objects;

public class Facade {

    private static final String PRIMITIVE_FORMAT = "primitive";
    private static final String STRING_FORMAT = "string";

    private static final String stringType = "string";
    private static final String intType = "int";
    private static final String byteType = "byte";
    private static final String unbufferedType = "unbuffered";

    public static boolean isDecorated = false;
    private static String previousType;
    private static String stringState = "";
    private static int intState;
    private static byte byteState;
    private static int stringStateCount;

    public static void log(int message) {
        write(PRIMITIVE_FORMAT, String.valueOf(message), intType);
    }

    public static void log(byte message) {
        write(PRIMITIVE_FORMAT, String.valueOf(message), byteType);
    }

    public static void log(boolean message){
        write(PRIMITIVE_FORMAT, String.valueOf(message), unbufferedType);
    }

    public static void log(Object message){
        checkBuffer(unbufferedType);
        write("reference", String.valueOf(message), unbufferedType);
    }

    public static void log(char message){
        write("char", String.valueOf(message), unbufferedType);
    }

    public static void log(String message){
        write(STRING_FORMAT, String.valueOf(message), stringType);
    }

    private static void write(String prefix, String payLoad, String newType) {
        checkBuffer(newType);

        if (newType.equals(unbufferedType)){
            System.out.println(decorate(prefix, payLoad));
        } else {
            accumulate(payLoad, newType);
        }
        previousType = newType;
    }

    private static void checkBuffer(String newType) {
        if (Objects.isNull(previousType)){
            previousType = newType;
        } else if (!newType.equals(previousType)){
            flush();
        }
    }

    private static void accumulate(String payLoad, String newType) {
        switch (newType){
            case intType:
                int intPayload = Integer.valueOf(payLoad);
                if (intPayload > Integer.MAX_VALUE - intState){
                    flush();
                }
                intState += intPayload;
                break;
            case byteType:
                int bytePayload = Byte.valueOf(payLoad);
                if (bytePayload > Byte.MAX_VALUE - byteState){
                    flush();
                }
                byteState += bytePayload;
                break;
            case stringType:
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
            case stringType:
                stringState = decorate(STRING_FORMAT, stringState);
                if (stringStateCount > 0){
                    System.out.println(String.format("%s (x%d)", stringState, ++ stringStateCount));
                } else {
                    System.out.println(stringState);
                }
                stringStateCount = 0;
                stringState = "";
                break;
            case intType:
                System.out.println(decorate(PRIMITIVE_FORMAT, intState));
                intState = 0;
                break;
            case byteType:
                System.out.println(decorate(PRIMITIVE_FORMAT, byteState));
                byteState = 0;
        }
    }

    private static String decorate(String prefix, Object payLoad){
        String stringPayLoad = String.valueOf(payLoad);
        if (isDecorated){
            return prefix + ": " + stringPayLoad;
        } else {
            return stringPayLoad;
        }
    }

    public static void clean(){
        previousType = "";
    }

}