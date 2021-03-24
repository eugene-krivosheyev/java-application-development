package com.acme.dbo.txlog;

public class Facade {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    public enum availableTypes  {NONE, INT, STR, BYTE};

    static availableTypes currentType = availableTypes.NONE;

    public static Integer accumulator = null;
    public static String strMessage = null;
    public static int strCounter = 0;


    public static void log (int message){
        if (currentType == availableTypes.INT){
            long i = accumulator.longValue() + message;
            if (i >= Integer.MAX_VALUE) {
                flush();
                logMessage(outputDecorate(PRIMITIVE_PREFIX, Integer.MAX_VALUE));
            }
             else {
                 accumulator = accumulator + message;
            }
        }
        else {
            accumulator = 0;
            accumulator = accumulator + message;
            currentType = availableTypes.INT;
        }
    }

    public static void log (byte message){
        if (currentType == availableTypes.BYTE){
            long i = accumulator.longValue() + message;
            if (i >= Byte.MAX_VALUE) {
                flush();
                logMessage(outputDecorate(PRIMITIVE_PREFIX, Byte.MAX_VALUE));
            }
            else {
                accumulator = accumulator + message;
            }
        }
        else {
            accumulator = 0;
            accumulator = accumulator + message;
            currentType = availableTypes.BYTE;
        }
    }

    public static void log (String message){
        if (currentType != availableTypes.STR) {
            flush();
            strMessage = message;
            currentType = availableTypes.STR;
        }
        else {
            if (strMessage == message){
                strCounter ++;
            }
            else {
                flush();
            }
        }
    }


    public static void log (Object message){
        logMessage(outputDecorate(REFERENCE_PREFIX, message));
    }


    public static void log (char message){
        logMessage(outputDecorate(CHAR_PREFIX, message));
    }



    public static void log (boolean message){
        logMessage(outputDecorate(PRIMITIVE_PREFIX, message));
    }





    private static void logMessage(String message) {
        System.out.println(message);
    }

    private static String outputDecorate(String prefix, Object message) {
        return prefix + message;
    }

    public static void flush () {
        if (currentType == availableTypes.INT){
            logMessage(outputDecorate(PRIMITIVE_PREFIX, accumulator));
            currentType = availableTypes.NONE;
            accumulator = null;
        }
        if (currentType == availableTypes.BYTE){
            logMessage(outputDecorate(PRIMITIVE_PREFIX, accumulator));
            currentType = availableTypes.NONE;
            accumulator = null;
        }
        if (currentType == availableTypes.STR){
            if (strCounter != 0 ){
                logMessage(outputDecorate(STRING_PREFIX, strMessage + " (x" + strCounter + ")"));
            }
            else {
                logMessage(outputDecorate(STRING_PREFIX, strMessage));
            }
            currentType = availableTypes.NONE;
            strMessage = "";
        }
    }

}
