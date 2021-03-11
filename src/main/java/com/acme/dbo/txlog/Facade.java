package com.acme.dbo.txlog;

public class Facade {

    private final static String PRIMITIVE_PREFIX = "primitive: ";
    private final static String STRING_PREFIX = "string: ";
    private final static String CHAR_PREFIX = "char: ";
    private final static String REFERENCE_PREFIX = "reference: ";

    public static void log(int message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message));
    }

    public static void log(byte message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message));
    }

    public static void log(char message) {
        printMessage(decorate(CHAR_PREFIX, message));
    }

    public static void log(String message) {
        printMessage(decorate(STRING_PREFIX, message));
    }

    public static void log(boolean message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message));
    }

    public static void log(Object message) {
        printMessage(decorate(REFERENCE_PREFIX, message));
    }

    private static void printMessage(Object message) {
        System.out.println(message);
    }

    private static String decorate(String prefix, Object message) {
        return prefix + message;
    }
}
