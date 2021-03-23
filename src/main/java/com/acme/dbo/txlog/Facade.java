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

    private static int intAccumulator = 0;
    private static String strAccumulator = "";
    private static int strCount = 0;

    private static String prevType = "";
    private static String currType = "";

    public static void log(byte message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(char message) {
        printMessage(decorate(CHAR_PREFIX, message, CHAR_POSTFIX));
    }

    public static void log(boolean message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(Object message) {
        if (message instanceof Integer) {
            currType = "Integer";
            Integer intMessage = (Integer) message;
            if ((intMessage > 0 && intAccumulator > (intAccumulator + intMessage))
            || (intMessage < 0 && intAccumulator < (intAccumulator + intMessage))) {
                // overflow
                flush();
            }
            intAccumulator += intMessage;
        } else if (message instanceof String) {
            currType = "String";
            strAccumulator = (String) message;
        } else {
            printMessage(decorate(REFERENCE_PREFIX, message, REFERENCE_POSTFIX));
        }
        if (!currType.equals(prevType)) {
            flush();
        }
        prevType = currType;
    }

    public static void flush() {
        if ("String".equals(prevType)) {
            printMessage(decorate(STRING_PREFIX, strAccumulator, STRING_POSTFIX));
            strAccumulator = "";
        } else if ("Integer".equals(prevType)) {
            printMessage(decorate(PRIMITIVE_PREFIX, intAccumulator, PRIMITIVE_POSTFIX));
            intAccumulator = 0;
        }
    }

    private static String decorate(String prefix, Object message, String postfix) {
        return prefix + message.toString() + postfix;
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
