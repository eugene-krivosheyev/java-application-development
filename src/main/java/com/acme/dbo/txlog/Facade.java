package com.acme.dbo.txlog;

public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String PRIMITIVES_MATRIX_PREFIX = "primitives matrix: ";
    public static final String REFERENCE_PREFIX = "reference: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String CHAR_PREFIX = "char: ";
    private static final String PRIMITIVE_POSTFIX = "";
    private static final String STRING_POSTFIX = "";
    private static Object previousLine = new Object();
    private static int stringSum = 1;
    private static int sum = 0;
    private static boolean accumulateFlag = false;

    public static void log(Integer message) {
        accumulateFlag = true;
        if ((previousLine instanceof Integer) && (!message.equals(Integer.MAX_VALUE))) {
            sum = (Integer) previousLine + message;
//            print(decorate(PRIMITIVE_PREFIX, sum, PRIMITIVE_POSTFIX));
            previousLine = sum;
        } else {
            print(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
            previousLine = message;
        }

        stringSum = 1;
    }

    public static void flush(){
        if (accumulateFlag) {
        print(decorate(PRIMITIVE_PREFIX, previousLine, PRIMITIVE_POSTFIX));
        sum =0;
        accumulateFlag = false;
        }
    }

    public static void log(int[][] message) {
        System.out.println(PRIMITIVES_MATRIX_PREFIX + "{");
        for (int[] ints : message) {
            System.out.print("{" + ints[0]);
            for (int j = 1; j < ints.length; j++) {
                System.out.print(", " + ints[j]);
            }
            System.out.println("}");
        }
        System.out.println("}");
        stringSum = 1;
    }

    public static void log(Integer... message) {
        for (Integer integer : message) {
            log(integer);
            flush();
        }
        stringSum = 1;
    }

    public static void log(String... message) {
        flush();
        for (String str : message) {
            log(str);
        }
        stringSum = 1;
    }

    public static void log(byte message) {
        flush();
        print(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
        stringSum = 1;
    }

    public static void log(String message) {
        flush();
        if (previousLine instanceof String & previousLine.equals(message)) {
            String summMessage = message + " (x" + ++stringSum + ")";
            print(decorate(STRING_PREFIX, summMessage, STRING_POSTFIX));
        } else {
            print(decorate(STRING_PREFIX, message, STRING_POSTFIX));
            previousLine = message;
            stringSum = 1;
        }
    }

    public static void log(Character message) {
        flush();
        print(decorate(CHAR_PREFIX, message, STRING_POSTFIX));
        stringSum = 1;
    }

    public static void log(Boolean message) {
        flush();
        print(decorate(PRIMITIVE_PREFIX, message, ""));
        stringSum = 1;
    }

    public static void log(Object message) {
        flush();
        print(decorate(REFERENCE_PREFIX, message, ""));
        stringSum = 1;
    }


    private static void print(Object message) {
        System.out.println(message);
    }

    private static String decorate(String prefix, Object message, String postfix) {
        return prefix + message + postfix;
    }
}
