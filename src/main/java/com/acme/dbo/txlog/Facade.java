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

    private static final String STRING_ACC = "string";
    private static final String INT_ACC = "integer";
    private static final String BYTE_ACC = "byte";
    private static final String CHAR_ACC = "char";
    private static final String BOOL_ACC = "boolean";
    private static final String OBJ_ACC = "object";

    private static String activeAccumulator = "";
    private static String stringAccumulator = "";
    private static String previousString = "";
    private static int exactStringCounter = 1;
    private static int intAccumulator = 0;
    private static byte byteAccumulator = 0;
    private static char charAccumulator = 0;
    private static boolean boolAccumulator = true;
    private static Object objectAccumulator = null;

    public static void log(int message) {
        if (!activeAccumulator.equals(INT_ACC) | (isNumberOverflow(message, intAccumulator, Integer.MAX_VALUE))) {
            resetActiveAccumulator(INT_ACC);
        }
        intAccumulator += message;

    }

    public static void log(char message) {
        if (!activeAccumulator.equals(CHAR_ACC)) {
            resetActiveAccumulator(CHAR_ACC);
        }
        charAccumulator += message;
    }

    public static void log(byte message) {
        if (!activeAccumulator.equals(BYTE_ACC) | (isNumberOverflow(message, byteAccumulator, Byte.MAX_VALUE))) {
            resetActiveAccumulator(BYTE_ACC);
        }
        byteAccumulator += message;
    }

    public static void log(boolean message) {
        resetActiveAccumulator(BOOL_ACC);
        boolAccumulator = message;
    }

    public static void log(String message) {
        boolean isEqualPrevious = previousString.equals(message);

        if (!activeAccumulator.equals(STRING_ACC) | !isEqualPrevious){
            resetActiveAccumulator(STRING_ACC);
            previousString = message;
            stringAccumulator = message;
        } else  {
            exactStringCounter += 1;
            stringAccumulator = message + " (x" + exactStringCounter + ")";
        }
    }

    public static void log(Object message) {
        outputDecoratedMessage(decorateMessage(message, OBJ_PREFIX, OBJ_POSTFIX));
        resetActiveAccumulator(OBJ_ACC);
        objectAccumulator = message;
    }

    public static void flush() {
        switch (activeAccumulator) {
            case STRING_ACC: {
                outputDecoratedMessage(decorateMessage(stringAccumulator, STRING_PREFIX, STRING_POSTFIX));
                stringAccumulator = "";
                previousString = "";
                exactStringCounter = 1;
                break;
            }
            case INT_ACC: {
                outputDecoratedMessage(decorateMessage(intAccumulator, PRIMITIVE_PREFIX, PRIMITIVE_POSTFIX));
                intAccumulator = 0;
                break;
            }
            case BYTE_ACC: {
                outputDecoratedMessage(decorateMessage(byteAccumulator, PRIMITIVE_PREFIX, PRIMITIVE_POSTFIX));
                byteAccumulator = 0;
                break;
            }
            case CHAR_ACC: {
                outputDecoratedMessage(decorateMessage(charAccumulator, CHAR_PREFIX, CHAR_POSTFIX));
                charAccumulator = 0;
                break;
            }
            case BOOL_ACC: {
                outputDecoratedMessage(decorateMessage(boolAccumulator, PRIMITIVE_PREFIX, PRIMITIVE_POSTFIX));
                boolAccumulator = true;
                break;
            }
            case OBJ_ACC: {
                outputDecoratedMessage(decorateMessage(objectAccumulator, OBJ_PREFIX, OBJ_POSTFIX));
                objectAccumulator = null;
                break;
            }
        }
        activeAccumulator = "";
    }

    private static String decorateMessage(Object message, String prefix, String postfix) {
        return prefix +  message.toString() + postfix;
    }

    private static void outputDecoratedMessage(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }

    private static void resetActiveAccumulator(String accumulator) {
        flush();
        activeAccumulator = accumulator;
    }

    private static boolean isNumberOverflow (long first, long second, long overflow) {
        return first + second > overflow;
    }


}
