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

    private static final String INTEGER_TYPE = "Integer";
    private static final String STRING_TYPE = "String";
    private static final String BYTE_TYPE = "Byte";
    public static final String REFERENCE_TYPE = "Reference";

    private static int intAccumulator = 0;
    private static String strAccumulator = "";
    private static int strAccumulatorCount = 0;
    private static byte byteAccumulator = 0;

    private static String prevType = "";
    private static String currType = "";

    public static void log(char message) {
        printMessage(decorate(CHAR_PREFIX, message, CHAR_POSTFIX));
    }

    public static void log(boolean message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(Object message) {
        if (message instanceof String) {
            currType = STRING_TYPE;
            accumulate((String) message);
        } else if (message instanceof Byte) {
            currType = BYTE_TYPE;
            accumulate((Byte) message);
        } else if (message instanceof Integer) {
            currType = INTEGER_TYPE;
            accumulate((Integer) message);
        } else {
            currType = REFERENCE_TYPE;
            flush();
            printMessage(decorate(REFERENCE_PREFIX, message, REFERENCE_POSTFIX));
        }
        if (!currType.equals(prevType)) {
            flush();
        }
        prevType = currType;
    }

    public static void flush() {
        if (STRING_TYPE.equals(prevType)) {
            printMessage(decorate(STRING_PREFIX, strAccumulatorWithCount(), STRING_POSTFIX));
            strAccumulator = "";
            strAccumulatorCount = 0;
        } else if (INTEGER_TYPE.equals(prevType)) {
            printMessage(decorate(PRIMITIVE_PREFIX, intAccumulator, PRIMITIVE_POSTFIX));
            intAccumulator = 0;
        } else if (BYTE_TYPE.equals(prevType)) {
            printMessage(decorate(PRIMITIVE_PREFIX, byteAccumulator, PRIMITIVE_POSTFIX));
            byteAccumulator = 0;
        }
        prevType = "";
    }

    private static String strAccumulatorWithCount() {
        if (strAccumulatorCount > 1) {
            return strAccumulator + " (x" + strAccumulatorCount + ")";
        }
        return strAccumulator;
    }

    private static void accumulate(String message) {
        if (!message.equals(strAccumulator)) {
            flush();
            strAccumulatorCount = 0;
            strAccumulator = message;
        }
        strAccumulatorCount++;
    }

    private static void accumulate(int message) {
        int sum = intAccumulator + message;
        if ((message > 0 && intAccumulator > sum) || (message < 0 && intAccumulator < sum)) {
            // overflow
            flush();
        }
        intAccumulator += message;
    }

    private static void accumulate(byte message) {
        byte sum = (byte) (byteAccumulator + message);
        if ((message > 0 && byteAccumulator > sum) || (message < 0 && byteAccumulator < sum)) {
            // overflow
            flush();
        }
        byteAccumulator += message;
    }

    private static String decorate(String prefix, Object message, String postfix) {
        return prefix + message.toString() + postfix;
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
