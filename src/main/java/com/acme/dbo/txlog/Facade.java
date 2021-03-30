package com.acme.dbo.txlog;

import java.util.Arrays;
import java.util.Collections;

public class Facade {

    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";
    private static final String PRIMITIVES_ARRAY = "primitives array: ";
    private static final String PRIMITIVES_MATRIX = "primitives matrix: ";
    private static final String INT_TYPE = "Int";
    private static final String BYTE_TYPE = "Byte";
    private static final String STRING_TYPE = "String";

    public static String currentType;
    public static String currentString;
    public static int accumulator;

    public static void log(int message, int... messages) {
        log(message);
        for (int item : messages) {
            log(item);
        }
    }

    public static void log(int[] message) {
        if (message == null) {
            System.out.println("ERROR: Parameter should not be null");
            return;
        }
        printLog(PRIMITIVES_ARRAY, intArrayToString(message));
    }

    public static void log(int[][] message) {
        if (message == null) {
            System.out.println("ERROR: Parameter should not be null");
            return;
        }

        StringBuilder builder = new StringBuilder("{" + System.lineSeparator());
        for (int i = 0; i < message.length; i++) {
            builder.append(intArrayToString(message[i]));
            builder.append(System.lineSeparator());
        }
        builder.append("}");
        printLog(PRIMITIVES_MATRIX, builder);
    }

    public static void log(int message) {
        flushOnTypeChange(INT_TYPE);
        int result = accumulator + message;

        logWithOverflowCheck(message, result);
        currentType = INT_TYPE;
    }

    public static void log(byte message) {
        flushOnTypeChange(BYTE_TYPE);
        byte result = (byte) (message + accumulator);

        logWithOverflowCheck(message, result);
        currentType = BYTE_TYPE;
    }

    public static void log(char message) {
        printLog(CHAR, message);
    }

    public static void log(String... message) {
        for (String str : message) {
            log(str);
        }
    }

    public static void log(String message) {
        flushOnTypeChange(STRING_TYPE);
        currentType = STRING_TYPE;
        if (currentString != null && !message.equals(currentString)) {
            flush();
        }
        currentString = message;
        accumulator++;

    }

    public static void log(boolean message) {
        printLog(PRIMITIVE, message);
    }

    public static void log(Object message) {
        printLog(REFERENCE, message);
    }

    private static void printLog(String prefix, Object message) {
        System.out.println(prefix + message);
    }

    public static void flush() {
        switch (currentType) {
            case INT_TYPE:
            case BYTE_TYPE:
                printLog(PRIMITIVE, accumulator);
                break;
            case STRING_TYPE:
                String postfix = accumulator == 1 ? "" : " (x" + accumulator + ")";
                printLog(STRING, currentString + postfix);
                break;
        }
        accumulator = 0;
    }

    private static void logWithOverflowCheck(int message, int result) {
        if ((result > 0 & accumulator < 0 & message < 0) || (result < 0 & accumulator > 0 & message > 0)) {
            flush();
            printLog(PRIMITIVE, message);
        } else {
            accumulator = result;
        }
    }

    private static void flushOnTypeChange(String type) {
        if (currentType != null && !currentType.equals(type)) {
            flush();
        }
    }

    private static String intArrayToString(int[] message) {
        StringBuilder builder = new StringBuilder("{");
        for (int i = 0; i < message.length; i++) {
            builder.append(message[i]);
            if (i < message.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("}");
        return builder.toString();
    }

}
