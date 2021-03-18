package com.acme.dbo.txlog;

public class Facade {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String OBJ_PREFIX = "reference: ";

    private static final String PRIMITIVE_POSTFIX= "";
    private static final String STRING_POSTFIX= "";
    private static final String CHAR_POSTFIX= "";
    private static final String OBJ_POSTFIX= "";

    public static void log(int message) {
        outputDecoratedMessage(decorateMessage(message, PRIMITIVE_PREFIX, PRIMITIVE_POSTFIX));
    }

    public static void log(char message) {
        outputDecoratedMessage(decorateMessage(message, CHAR_PREFIX, CHAR_POSTFIX));
    }

    public static void log(byte message) {
        outputDecoratedMessage(decorateMessage(message, PRIMITIVE_PREFIX, PRIMITIVE_POSTFIX));
    }

    public static void log(boolean message) {
        outputDecoratedMessage(decorateMessage(message, PRIMITIVE_PREFIX, PRIMITIVE_POSTFIX));
    }

    public static void log(String message) {
        outputDecoratedMessage(decorateMessage(message, STRING_PREFIX, STRING_POSTFIX));
    }

    public static void log(Object message) {
        outputDecoratedMessage(decorateMessage(message, OBJ_PREFIX, OBJ_POSTFIX));
    }

    private static String decorateMessage(Object message, String prefix, String postfix) {
        return prefix +  message.toString() + postfix;
    }

    private static void outputDecoratedMessage(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
