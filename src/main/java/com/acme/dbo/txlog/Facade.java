/**
 * jkgjdhkgjhdfkgjdhfk
 */
package com.acme.dbo.txlog;


public class Facade {
    public static final String OBJECT_PREFIX = "reference: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string: ";
    private static final String PRIMITIVE_POSTFIX = "";
    private static final String CHAR_POSTFIX = "";
    private static final String OBJECT_POSTFIX = "";
    private static final String STRING_POSTFIX = "";

    public static void log(char message) {
        printMessage(decorate(CHAR_PREFIX, message, CHAR_POSTFIX));
    }

    public static void log(int message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(boolean message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(byte message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(String message) {
        printMessage(decorate(STRING_PREFIX, message, STRING_POSTFIX));
    }

    public static void log(Object message) {
        printMessage(decorate(OBJECT_PREFIX, message, OBJECT_POSTFIX));
    }

    private static String decorate(String stringPrefix, Object message, String stringPostfix) {
        System.out.printf("%s %s %s", stringPrefix, message, stringPostfix);
        return stringPrefix + message + stringPostfix;
    }

    private static void printMessage(Object message) {
        System.out.println(message);
    }
}
