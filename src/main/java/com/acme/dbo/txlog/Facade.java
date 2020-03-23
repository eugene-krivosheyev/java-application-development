package com.acme.dbo.txlog;

import java.util.Objects;

import static java.lang.String.valueOf;

public class Facade {

    private static final String PRIMITIVE = "primitive";
    private static final String CHAR = "char";
    private static final String REFERENCE = "reference";
    private static final String STRING = "string";

    private static final int OTHER_MESSAGE = 0;
    private static final int INT_MESSAGE = 1;
    private static final int BYTE_MESSAGE = 2;
    private static final int STRING_MESSAGE = 3;

    private static int intSum = 0;
    private static byte byteSum = 0;
    private static int stringCount = 0;
    private static String lastString;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void log(int message) {

        try {
            intSum = Math.addExact(intSum, message);
            logMessage(decorateMessage(intSum), intSum);
        } catch (ArithmeticException e) {
            logMessage(decorateMessage(intSum), intSum);
            logMessage(decorateMessage(message), message);
            intSum = message;
        }
        clearByMessageType(INT_MESSAGE);
    }

    public static void log(byte message) {

        if ((int)message + byteSum >= Byte.MAX_VALUE) {
            byteSum = 0;
        } else {
            byteSum += message;
        }
        logMessage(decorateMessage(byteSum), byteSum);
        logMessage(decorateMessage(message), message);
        clearByMessageType(BYTE_MESSAGE);
    }

    public static void log(char message) {
        logMessage(decorateMessage(message), valueOf(message));
        clearByMessageType(OTHER_MESSAGE);
    }

    public static void log(String message) {
        if (Objects.equals(message, lastString)) {
            stringCount++;
        } else {
            stringCount = 0;
        }
        logMessage(decorateMessage(message), message);
        lastString = message;
        clearByMessageType(STRING_MESSAGE);
    }

    public static void log(boolean message) {
        logMessage(decorateMessage(message), valueOf(message));
        clearByMessageType(OTHER_MESSAGE);
    }

    public static void log(Object message) {
        logMessage(decorateMessage(message), message);
        clearByMessageType(OTHER_MESSAGE);
    }

    private static void logMessage(String prefix, Object message) {
        stringBuilder.append(prefix).append(": ").append(message).append(System.lineSeparator());
    }

    private static void logMessage(String prefix, String message) {
        if (stringCount == 0) {
            stringBuilder.append(prefix).append(": ").append(message).append(System.lineSeparator());
        } else {
            String substring = prefix + ": " + message;
            int index = stringBuilder.lastIndexOf(substring) + substring.length();
            stringBuilder.delete(index, stringBuilder.length());
            stringBuilder.append(" (x").append(stringCount + 1).append(")").append(System.lineSeparator());
        }
    }

    public static String decorateMessage(int message) {
        return PRIMITIVE;
    }

    public static String decorateMessage(byte message) {
        return PRIMITIVE;
    }

    public static String decorateMessage(char message) {
        return CHAR;
    }

    public static String decorateMessage(boolean message) {
        return PRIMITIVE;
    }

    public static String decorateMessage(String message) {
        return STRING;
    }

    public static String decorateMessage(Object message) {
        return REFERENCE;
    }

    public static void flush() {
        System.out.print(stringBuilder);
        stringBuilder = new StringBuilder();
        clearByMessageType(OTHER_MESSAGE);
    }

    public static void clearByMessageType(int type) {
        switch (type) {
            case INT_MESSAGE: {
                byteSum = 0;
                lastString = null;
                stringCount = 0;
                break;
            }
            case BYTE_MESSAGE: {
                intSum = 0;
                lastString = null;
                stringCount = 0;
                break;
            }
            case STRING_MESSAGE: {
                intSum = 0;
                byteSum = 0;
                break;
            }
            default: {
                intSum = 0;
                byteSum = 0;
                stringCount = 0;
                lastString = null;
            }
        }
    }
}
