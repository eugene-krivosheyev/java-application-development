package com.acme.dbo.txlog;

public class Facade {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String OBJ_PREFIX = "reference: ";
    private static final String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
    private static final String PRIMITIVE_MATRIX_PREFIX = "primitives matrix: ";

    private static final String PRIMITIVE_POSTFIX= "";
    private static final String STRING_POSTFIX= "";
    private static final String CHAR_POSTFIX= "";
    private static final String OBJ_POSTFIX= "";
    private static final String PRIMITIVE_ARRAY_POSTFIX= "";
    private static final String PRIMITIVE_MATRIX_POSTFIX = "";

    private static final String ARRAY_PREFIX = "{";
    private static final String ARRAY_DEVIDER = ", ";
    private static final String ARRAY_POSTFIX = "}";

    private static final String MATRIX_PREFIX = "{" + System.lineSeparator();
    private static final String MATRIX_POSTFIX = "}";

    private static final String STRING_ACC = "string";
    private static final String INT_ACC = "integer";
    private static final String BYTE_ACC = "byte";
    private static final String CHAR_ACC = "char";
    private static final String BOOL_ACC = "boolean";
    private static final String OBJ_ACC = "object";
    private static final String INT_ARRAY_ACC = "int_array";
    private static final String INT_MATRIX_ACC = "int_matrix";

    private static String activeAccumulator = "";
    private static String stringAccumulator = "";
    private static String previousString = "";
    private static int exactStringCounter = 1;
    private static int intAccumulator = 0;
    private static byte byteAccumulator = 0;
    private static char charAccumulator = 0;
    private static boolean boolAccumulator = true;
    private static Object objectAccumulator = null;
    private static String intArrayAccumulator = "";
    private static String intMatrixAccumulator = "";

    public static void log(int message) {
        resetNumberAccumulator(INT_ACC, intAccumulator, message, Integer.MAX_VALUE);
        intAccumulator += message;
    }

    public static void log(byte message) {
        resetNumberAccumulator(BYTE_ACC, byteAccumulator, message, Byte.MAX_VALUE);
        byteAccumulator += message;
    }

    public static void log(char message) {
        if (!activeAccumulator.equals(CHAR_ACC)) {
            resetActiveAccumulator(CHAR_ACC);
        }
        charAccumulator += message;
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

    public static void log(String... messages) {
        for (String message: messages) {
            log(message);
        }
    }

    public static void log(int[] intArrayMessage) {
        resetActiveAccumulator(INT_ARRAY_ACC);
        intArrayAccumulator = arrayToString(intArrayMessage);
    }

    public static void log(int[][] intMatrix) {
        resetActiveAccumulator(INT_MATRIX_ACC);
        intMatrixAccumulator = matrixToString(intMatrix);
    }

    public static void log(Object message) {
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

            case INT_ARRAY_ACC: {
                outputDecoratedMessage(decorateMessage(intArrayAccumulator, PRIMITIVE_ARRAY_PREFIX, PRIMITIVE_ARRAY_POSTFIX));
                intArrayAccumulator = "";
                break;
            }

            case INT_MATRIX_ACC: {
                outputDecoratedMessage(decorateMessage(intMatrixAccumulator, PRIMITIVE_MATRIX_PREFIX, PRIMITIVE_MATRIX_POSTFIX));
                intMatrixAccumulator = "";
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

    private static void resetNumberAccumulator(String setAccumulator, int accumulatorValue, int currentValue, int accumulatorLimit) {
        if (!activeAccumulator.equals(setAccumulator) | (isNumberOverflow(currentValue, accumulatorValue, accumulatorLimit))) {
            resetActiveAccumulator(setAccumulator);
        }
    }

    private static String arrayToString(int[] intArray) {
        String buffer = ARRAY_PREFIX;
        for (int element: intArray) {
            if (!buffer.equals(ARRAY_PREFIX)) {
                buffer = buffer + ARRAY_DEVIDER + element;
            } else {
                buffer = buffer + element;
            }
        }
        return buffer + ARRAY_POSTFIX;
    }

    private static String matrixToString(int[][] matrix) {
        String buffer = MATRIX_PREFIX;
        for (int[] array: matrix) {
            buffer = buffer + arrayToString(array) + System.lineSeparator();
        }
        return buffer + MATRIX_POSTFIX;
    }
}
