package com.acme.dbo.txlog;

public class Facade {

    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";
    private static final String INT_TYPE = "Int";
    private static final String BYTE_TYPE = "Byte";
    private static final String STRING_TYPE = "String";

    public static String currentType;
    public static String currentString;
    public static int accumulator;

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

}
