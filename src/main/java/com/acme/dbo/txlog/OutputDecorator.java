package com.acme.dbo.txlog;

public class OutputDecorator implements Logger {

    private static String PRIMITIVE_PREFIX = "primitive: ";
    private static String CHAR_PREFIX = "char: ";
    private static String STRING_PREFIX = "string: ";
    private static String REFERENCE_PREFIX = "reference: ";
    private static String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
    private static String PRIMITIVE_MATRIX_PREFIX = "primitives matrix: ";
    private static String LEFT_BRACKET = "{";
    private static String RIGHT_BRACKET = "}";
    private static String ARRAY_DIVIDER = ", ";

    private Logger logger;

    OutputDecorator(Logger logger) {
       this.logger = logger;
    }

    public void log(byte message) {
        logger.log(PRIMITIVE_PREFIX + message);
    }

    public void log(String message) {
        logger.log(STRING_PREFIX + message);
    }

    public void log(char message) {
        logger.log(CHAR_PREFIX + message);
    }

    public void log(int message) {
        logger.log(PRIMITIVE_PREFIX + message);
    }

    public void log(float message) {
        logger.log(PRIMITIVE_PREFIX + message);
    }

    public void log(boolean message) {
        logger.log(PRIMITIVE_PREFIX + message);
    }

    public void log(Object message) {
        logger.log(REFERENCE_PREFIX + message);
    }

    public void log(int[] message) { logger.log(PRIMITIVE_ARRAY_PREFIX + arrayToString(message)); }

    public void log(int[][] message) { logger.log(PRIMITIVE_MATRIX_PREFIX + matrixToString(message)); }

    private static String arrayToString(int[] array) {
        String result = LEFT_BRACKET;
        for (int i = 0; i < array.length; ++i)
        {
            result += array[i];
            if (i != array.length - 1) {
                result += ARRAY_DIVIDER;
            }
        }
        result += RIGHT_BRACKET;
        return result;
    }

    private static String matrixToString(int[][] array) {
        String result = LEFT_BRACKET + System.lineSeparator();
        for (int i = 0; i < array.length; ++i)
        {
            result += arrayToString(array[i]) + System.lineSeparator();
        }
        result += RIGHT_BRACKET;
        return result;
    }
}
