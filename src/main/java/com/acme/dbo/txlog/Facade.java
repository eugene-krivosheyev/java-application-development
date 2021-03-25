package com.acme.dbo.txlog;

public class Facade {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    public enum availableTypes  {NONE, INT, STR, BYTE};
    static availableTypes currentType = availableTypes.NONE;

    public static Integer accumulator = null;
    public static int strCounter = 0;
    public static String strMessage = null;


    public static void log (int message){
        if (currentType == availableTypes.INT){
            checkForMaxValueAndIncreaseAccumulator(message, Integer.MAX_VALUE);
        }
        else {
            flush();
            increaseAccumulator(message, availableTypes.INT);
        }
    }

    public static void log (byte message){
        if (currentType == availableTypes.BYTE){
            checkForMaxValueAndIncreaseAccumulator(message, Byte.MAX_VALUE);
        }
        else {
            flush();
            increaseAccumulator(message, availableTypes.BYTE);
        }
    }

    public static void log (String message){
        if (currentType != availableTypes.STR || strMessage != message) {
            flushAndRemeberCurrentStateForString(message);
        }
        else {
            strCounter ++;
            currentType = availableTypes.STR;
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

    private static void checkForMaxValueAndIncreaseAccumulator(int message, int maxValue) {
        long i = accumulator.longValue() + message;
        if (i >= maxValue) {
            flush();
            logMessage(outputDecorate(PRIMITIVE_PREFIX, maxValue));
        } else {
            accumulator = accumulator + message;
        }
    }

    private static void increaseAccumulator(int message, availableTypes anInt) {
        accumulator = 0;
        accumulator = accumulator + message;
        currentType = anInt;
    }

    private static void flushAndRemeberCurrentStateForString(String message) {
        flush();
        strMessage = message;
        currentType = availableTypes.STR;
    }

    public static void flush () {
        if (currentType == availableTypes.INT){
            logMessage(outputDecorate(PRIMITIVE_PREFIX, accumulator));
        }
        if (currentType == availableTypes.BYTE){
            logMessage(outputDecorate(PRIMITIVE_PREFIX, accumulator));
        }
        if (currentType == availableTypes.STR){
            if (strCounter >= 1 ){
                strCounter++;
                logMessage(outputDecorate(STRING_PREFIX, strMessage + " (x" + strCounter + ")"));
            }
            else {
                logMessage(outputDecorate(STRING_PREFIX, strMessage));
            }
        }
        strCounter = 0;
        strMessage = "";
        accumulator = null;
        currentType = availableTypes.NONE;
    }

}
