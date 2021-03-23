package com.acme.dbo.txlog;

public class Facade {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    private static Integer int_accumulator = null;
    private static String str_accumulator = null;


    public static void log(Object message) {
        logMessage(outputDecorate(REFERENCE_PREFIX, message));
    }

    public static void log(String message) {
        if (int_accumulator == null && str_accumulator == null) {
            str_accumulator = message;
            logMessage(outputDecorate(STRING_PREFIX, str_accumulator));
        } else logMessage(outputDecorate(STRING_PREFIX, message));
    }

    public static void log (char message){
        logMessage(outputDecorate(CHAR_PREFIX, message));
    }

    public static void log (int message) {
        if (int_accumulator == null && str_accumulator == null) {
            int_accumulator = message;
        } else if (int_accumulator != null) {
            int_accumulator = int_accumulator + message;
        }
        //else logMessage(outputDecorate(PRIMITIVE_PREFIX, int_accumulator));
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

    public static void flush() {
        if (int_accumulator != null) {
            logMessage(outputDecorate(PRIMITIVE_PREFIX, int_accumulator));
        } else if (str_accumulator != null) {
            logMessage(outputDecorate(PRIMITIVE_PREFIX, str_accumulator));
        }

        int_accumulator = null;
        str_accumulator = null;
    }
}
