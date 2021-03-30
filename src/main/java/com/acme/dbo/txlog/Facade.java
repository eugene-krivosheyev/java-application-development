package com.acme.dbo.txlog;

public class Facade {

    public static final String PREFIX_PRIMITIVE = "primitive:";
    public static final String PREFIX_PRIMITIVES_ARRAY = "primitives array:";
    public static final String PREFIX_PRIMITIVES_MATRIX = "primitives matrix:";
    public static final String PREFIX_PRIMITIVES_MULTIMATRIX = "primitives multimatrix:";
    public static final String PREFIX_CHAR = "char:";
    public static final String PREFIX_REFERENCE = "reference:";

    public static final String LOGGING_TYPE_INT = "int";
    public static final String LOGGING_TYPE_BYTE = "byte";
    public static final String LOGGING_TYPE_STRING = "string";

    private static long numbersAccumulator = 0;
    private static String lastStringValue = null;
    private static int equalsStringsCount = 0;

    private static String lastLoggedType = null;

    public static void log(int message) {
        if (!LOGGING_TYPE_INT.equals(lastLoggedType)) {
            flush();
        }

        logNumber(message, Integer.MAX_VALUE);
        lastLoggedType = LOGGING_TYPE_INT;
    }

    public static void log(byte message) {
        if (!LOGGING_TYPE_BYTE.equals(lastLoggedType)) {
            flush();
        }

        logNumber(message, Byte.MAX_VALUE);
        lastLoggedType = LOGGING_TYPE_BYTE;
    }

    private static void logNumber(int message, int maxValue) {
        if (numbersAccumulator + message > maxValue) {
            flush();
            numbersAccumulator = message;
        } else {
            numbersAccumulator += message;
        }
    }

    public static void log(int... message) {
        flush();
        logInternal(decorate(PREFIX_PRIMITIVES_ARRAY, arrayToString(message)));
    }

    public static void log(int[][] message) {
        flush();

        StringBuilder sb = new StringBuilder("{" + System.lineSeparator());
        for (int[] ints : message) {
            sb.append(arrayToString(ints)).append(System.lineSeparator());
        }
        sb.append("}");
        logInternal(decorate(PREFIX_PRIMITIVES_MATRIX, sb.toString()));
    }

    public static void log(int[][][][] message) {
        flush();

        StringBuilder sb = new StringBuilder("{" + System.lineSeparator());
        for (int[][][] array3d : message) {
            sb.append("{").append(System.lineSeparator());
            for (int[][] array2d : array3d) {
                sb.append("{").append(System.lineSeparator());
                for (int[] array : array2d) {
                    sb.append(arrayToString(array, true)).append(System.lineSeparator());
                }
                sb.append("}").append(System.lineSeparator());
            }
            sb.append("}").append(System.lineSeparator());
        }
        sb.append("}");
        logInternal(decorate(PREFIX_PRIMITIVES_MULTIMATRIX, sb.toString()));
    }

    private static String arrayToString(int[] arr) {
        return arrayToString(arr, false);
    }

    private static String arrayToString(int[] arr, boolean isNewLineForBraces) {
        StringBuilder sb = new StringBuilder("{").append(isNewLineForBraces ? System.lineSeparator() : "");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(isNewLineForBraces ? System.lineSeparator() : "").append("}");
        return sb.toString();
    }

    public static void log(boolean message) {
        flush();
        logInternal(decorate(PREFIX_PRIMITIVE, message));
    }

    public static void log(char message) {
        flush();
        logInternal(decorate(PREFIX_CHAR, message));
    }

    public static void log(String... message) {
        for (String m : message) {
            log(m);
        }
    }

    public static void log(String message) {
        if (!LOGGING_TYPE_STRING.equals(lastLoggedType)) {
            flush();
        }

        if (lastStringValue != null) {
            if (lastStringValue.equals(message)) {
                equalsStringsCount++;
            } else {
                flush();
                lastStringValue = message;
                equalsStringsCount = 1;
            }
        } else {
            lastStringValue = message;
            equalsStringsCount = 1;
        }
        lastLoggedType = LOGGING_TYPE_STRING;
    }

    public static void log(Object message) {
        flush();
        logInternal(decorate(PREFIX_REFERENCE, message));
    }

    public static String decorate(String prefix, Object message) {
        return prefix + " " + message;
    }

    public static void logInternal(String message) {
        System.out.println(message);
    }

    public static void flush() {
        if (LOGGING_TYPE_INT.equals(lastLoggedType)) {
            logInternal(decorate(PREFIX_PRIMITIVE, numbersAccumulator));
        } else if (LOGGING_TYPE_BYTE.equals(lastLoggedType)) {
            logInternal(decorate(PREFIX_PRIMITIVE, numbersAccumulator));
        } else if (LOGGING_TYPE_STRING.equals(lastLoggedType)) {
            String msg = lastStringValue;
            if (equalsStringsCount > 1) {
                msg += " (x" + equalsStringsCount + ")";
            }
            logInternal(decorate("string:", msg));
        }

        resetState();
    }

    private static void resetState() {
        lastLoggedType = null;
        numbersAccumulator = 0;
        lastStringValue = null;
        equalsStringsCount = 0;
    }
}
