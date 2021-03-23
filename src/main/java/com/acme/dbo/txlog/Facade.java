package com.acme.dbo.txlog;

public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string prefix: ";
    private static final String PRIMITIVE_POSTFIX = "";
    private static final String STRING_POSTFIX = "";

    private static final String INT_TYPE = "Int";
    private static final String BYTE_TYPE = "Byte";
    private static final String STRING_TYPE = "String";

    private static String lastType;

    private static long accumulator;

    private static String lastString;

    public static void flush() {

        if (lastType == null) {
            return;
        }

        switch (lastType) {
            case INT_TYPE:
            case BYTE_TYPE:
                print(decorate(PRIMITIVE_PREFIX, accumulator, PRIMITIVE_POSTFIX));
                break;
            case STRING_TYPE:
                flushString();
            default:
                break;
        }

        accumulator = 0;
        lastString = null;
    }

    public static void log(Integer message) {
        updateLastType(INT_TYPE);

        loggingDigitalValue(message, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static void log(byte message) {
        updateLastType(BYTE_TYPE);

        loggingDigitalValue(message, Byte.MAX_VALUE, Byte.MIN_VALUE);
    }

    private static void updateLastType(String typeName) {
        if (lastType != null && !lastType.equals(typeName)) {
            flush();
        }

        lastType = typeName;
    }

    private static void loggingDigitalValue(long value, long maxValue, long minValue) {
        long result = accumulator + value;

        if (result > maxValue) {
            flush();
        } else if (result < minValue) {
            flush();
        }

        accumulator += value;
    }

    public static void log(String message) {
        updateLastType("string");

        print(decorate(STRING_PREFIX, message, STRING_POSTFIX));
    }

    public static void log(Object message) {
        print(decorate("", message, ""));
    }


    private static void print(Object message) {
        System.out.println(message);
    }

    private static String decorate(String prefix, Object message, String postfix) {
        return prefix + message + postfix;
    }
}
