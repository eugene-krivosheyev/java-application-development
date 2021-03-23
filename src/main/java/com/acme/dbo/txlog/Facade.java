package com.acme.dbo.txlog;

public class Facade {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";
    public static final String PRIMITIVE_POSTFIX = "";
    public static final String CHAR_POSTFIX = "";
    private static final String STRING_POSTFIX = "";
    private static final String REFERENCE_POSTFIX = "";


    public static void log(int message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(byte message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(char message) {
        printMessage(decorate(CHAR_PREFIX, message, CHAR_POSTFIX));
    }

    public static void log(String message) {
        printMessage(decorate(STRING_PREFIX, message, STRING_POSTFIX));
    }

    public static void log(boolean message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(Object message) {
        printMessage(decorate(REFERENCE_PREFIX, message, REFERENCE_POSTFIX));
    }

    private static String decorate(String prefix, Object message, String postfix) {
        return prefix + message.toString() + postfix;
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
