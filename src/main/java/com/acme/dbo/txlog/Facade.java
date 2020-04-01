package com.acme.dbo.txlog;

public class Facade {

    private static final String PRIMITIVE_PREFIX = "primitive";
    private static final String CHAR_PREFIX      = "char";
    private static final String STRING_PREFIX    = "string";
    private static final String REFERENCE_PREFIX = "reference";

    private static void write(String message) {
        System.out.println(message);
    }

    private static String logFormat(String prefix, String message) {
        return prefix + ": " + message;
    }

    private static void logPrimitive(Object message) {
        write(logFormat(PRIMITIVE_PREFIX, message.toString()));
    }

    private static void logReference(Object message) {
        write(logFormat(REFERENCE_PREFIX, message.toString()));
    }

    private static void logChar(Character message) {
        write(logFormat(CHAR_PREFIX, message.toString()));
    }

    private static void logString(String message) {
        write(logFormat(STRING_PREFIX, message));
    }

    public static void log(int message) {
        logPrimitive(message);
    }

    public static void log(byte message) {
        logPrimitive(message);
    }

    public static void log(boolean message) {
        logPrimitive(message);
    }

    public static void log(Object message) {
        logReference(message);
    }

    public static void log(char message) {
        logChar(message);
    }

    public static void log(String message) {
        logString(message);
    }

}