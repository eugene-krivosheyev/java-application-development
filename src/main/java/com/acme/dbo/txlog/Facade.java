package com.acme.dbo.txlog;

public class Facade {

    private static final String PRIMITIVE_PREFIX = "primitive";
    private static final String CHAR_PREFIX      = "char";
    private static final String STRING_PREFIX    = "string";
    private static final String REFERENCE_PREFIX = "reference";

    private static void writer(String message) {
        System.out.println(message);
    }

    private static String logFormatter(String prefix, String message) {
        return prefix + ": " + message;
    }

    private static void primitiveLogger(Object message) {
        writer(logFormatter(PRIMITIVE_PREFIX, message.toString()));
    }

    private static void referenceLogger(Object message) {
        writer(logFormatter(REFERENCE_PREFIX, message.toString()));
    }

    private static void charLogger(Character message) {
        writer(logFormatter(CHAR_PREFIX, message.toString()));
    }

    private static void stringLogger(String message) {
        writer(logFormatter(STRING_PREFIX, message));
    }

    public static void log(int message) {
        primitiveLogger(message);
    }

    public static void log(byte message) {
        primitiveLogger(message);
    }

    public static void log(boolean message) {
        primitiveLogger(message);
    }

    public static void log(Object message) {
        referenceLogger(message);
    }

    public static void log(char message) {
        charLogger(message);
    }

    public static void log(String message) {
        stringLogger(message);
    }

}