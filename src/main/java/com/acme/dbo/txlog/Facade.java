package com.acme.dbo.txlog;

public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    public static void log(int message) {
        printMessage(decorate(PRIMITIVE_PREFIX,message));
    }

    public static void log(char message) {
        printMessage(decorate(CHAR_PREFIX, message));
    }

    public static void log(String message) {
        printMessage(decorate(STRING_PREFIX, message));
    }

    public static void log(byte message) { printMessage(decorate(PRIMITIVE_PREFIX, message)); }

    public static void log(boolean message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message));
    }

    public static void log(Object message) { printMessage(decorate(REFERENCE_PREFIX, message)); }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static String decorate(String stringPrefix, Object message) {
        return stringPrefix + message;
    }
}
