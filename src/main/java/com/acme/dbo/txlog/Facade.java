package com.acme.dbo.txlog;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.String.valueOf;
import static java.lang.System.lineSeparator;

public class Facade {

    private static final String PRIMITIVE = "primitive";
    private static final String CHAR = "char";
    private static final String REFERENCE = "reference";
    private static final String STRING = "string";
    private static final String PRIMITIVES_ARRAY = "primitives array";
    private static final String PRIMITIVES_MATRIX = "primitives matrix";
    private static final String PRIMITIVES_MULTIMATRIX = "primitives multimatrix";

    private static final int OTHER_MESSAGE = 0;
    private static final int INT_MESSAGE = 1;
    private static final int BYTE_MESSAGE = 2;
    private static final int STRING_MESSAGE = 3;

    private static int intSum = 0;
    private static byte byteSum = 0;
    private static int stringCount = 0;
    private static String lastString;

    public static void flush() {
        clearIntCount();
        clearByteCount();
        clearLastString();
    }

    public static void log(int... message) {
        logMessage(decorateMessage(message), getStringFromIntArrayString(Arrays.toString(message)));
    }

    public static void log(int message) {
        try {
            intSum = Math.addExact(intSum, message);
        } catch (ArithmeticException e) {
            logMessage(decorateMessage(message), message);
            intSum = message;
        } finally {
            logMessage(decorateMessage(intSum), intSum);
        }
        clearByMessageType(INT_MESSAGE);
    }

    public static void log(int[][] message) {
        logMessage(decorateMessage(message), getStringFromIntArrayString(Arrays.deepToString(message)));
        clearByMessageType(OTHER_MESSAGE);
    }

    public static void log(int[][][][] message) {
        logMessage(decorateMessage(message), getStringFromIntArrayString(Arrays.deepToString(message)));
        clearByMessageType(OTHER_MESSAGE);
    }

    public static void log(byte message) {
        if ((int) message + byteSum >= Byte.MAX_VALUE) {
            byteSum = message;
            logMessage(decorateMessage(message), message);
        } else {
            byteSum += message;
        }
        logMessage(decorateMessage(byteSum), byteSum);
        clearByMessageType(BYTE_MESSAGE);
    }

    public static void log(char message) {
        logMessage(decorateMessage(message), valueOf(message));
        clearByMessageType(OTHER_MESSAGE);
    }

    public static void log(String... messages) {
        for (String message : messages) {
            log(message);
        }
    }

    public static void log(String message) {
        if (Objects.equals(message, lastString)) {
            stringCount++;
        } else {
            stringCount = 0;
            flush();
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
        System.out.println(prefix + ": " + message);
    }

    private static void logMessage(String prefix, String message) {
        if (stringCount == 0) {
            System.out.println(prefix + ": " + message);
        } else {
            System.out.println(prefix + ": " + message + " (x" + (stringCount + 1) + ")");
        }
    }

    private static String decorateMessage(int message) {
        return PRIMITIVE;
    }

    private static String decorateMessage(byte message) {
        return PRIMITIVE;
    }

    private static String decorateMessage(char message) {
        return CHAR;
    }

    private static String decorateMessage(boolean message) {
        return PRIMITIVE;
    }

    private static String decorateMessage(String message) {
        return STRING;
    }

    private static String decorateMessage(Object message) {
        return REFERENCE;
    }

    private static String decorateMessage(int[] message) {
        return PRIMITIVES_ARRAY;
    }

    private static String decorateMessage(int[][] message) {
        return PRIMITIVES_MATRIX;
    }

    private static String decorateMessage(int[][][][] message) {
        return PRIMITIVES_MULTIMATRIX;
    }

    private static String getStringFromIntArrayString(String arrayString) {
        String resultString = arrayString
                .replace("[", "{")
                .replace("]", "}")
                .replace("}, {", "}" + lineSeparator() + "{");

        while (resultString.contains("{{") || resultString.contains("}}")) {
            resultString = resultString.replace("{{", "{" + lineSeparator() + "{")
                    .replace("}}", "}" + lineSeparator() + "}");
        }

        resultString = resultString.replaceAll("\\{(\\d+)}", "{" + lineSeparator() + "$1" + lineSeparator() + "}");

        return resultString;
    }

    private static void clearByMessageType(int messageType) {
        switch (messageType) {
            case INT_MESSAGE: {
                clearByteCount();
                clearLastString();
                break;
            }
            case BYTE_MESSAGE: {
                clearIntCount();
                clearLastString();
                break;
            }
            case STRING_MESSAGE: {
                clearIntCount();
                clearByteCount();
                break;
            }
            default: {
                flush();
            }
        }
    }

    private static void clearIntCount() {
        intSum = 0;
    }

    private static void clearByteCount() {
        byteSum = 0;
    }

    private static void clearLastString() {
        lastString = null;
        stringCount = 0;
    }
}
