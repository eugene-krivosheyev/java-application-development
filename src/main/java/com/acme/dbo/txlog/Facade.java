package com.acme.dbo.txlog;

public class Facade {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    //Вариант с type switching
    /* public static void log (Object message){

        if ((message instanceof Integer)|(message instanceof Byte)|(message instanceof Boolean)) {
            logMessage(outputDecorate(PRIMITIVE_PREFIX, message));
        }
        else if ((message instanceof Character)) {
            logMessage(outputDecorate(CHAR_PREFIX, message));
        }
        else if ((message instanceof String)) {
            logMessage(outputDecorate(STRING_PREFIX, message));
        }
        else {
            logMessage(outputDecorate(REFERENCE_PREFIX, message));
        }
    }
    */

    public static void log (Object message){
        logMessage(outputDecorate(REFERENCE_PREFIX, message));
    }

    public static void log (String message){
        logMessage(outputDecorate(STRING_PREFIX, message));
    }

    public static void log (char message){
        logMessage(outputDecorate(CHAR_PREFIX, message));
    }

    public static void log (int message){
        logMessage(outputDecorate(PRIMITIVE_PREFIX, message));
    }

    public static void log (byte message){
        logMessage(outputDecorate(PRIMITIVE_PREFIX, message));
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

}
