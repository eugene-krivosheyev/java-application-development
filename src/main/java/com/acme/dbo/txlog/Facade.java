package com.acme.dbo.txlog;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.lineSeparator;

public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String REFERENCE_PREFIX = "reference: ";
    private static final String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
    private static final String PRIMITIVE_MATRIX_PREFIX = "primitives matrix: ";
    private static final String PRIMITIVE_MULTIMATRIX_PREFIX = "primitives multimatrix: ";

    private static Integer intMessagesAccumulated = null;
    private static String stringMesssagesAccumulated = null;
    private static Integer byteMessagesAccumulated = null;
    private static Integer duplicatedStringMessagesCounter = 0;

    public static void log(int message) {
        if (intMessagesAccumulated == null || ((long) intMessagesAccumulated + (long) message > Integer.MAX_VALUE)) {
            flush();
            intMessagesAccumulated = message;
        } else {
            intMessagesAccumulated += message;
        }
    }

    public static void log(char message) {
        flush();
        printMessage(decorate(CHAR_PREFIX, message));
    }

    public static void log(String message) {
        if (stringMesssagesAccumulated == null) {
            stringMesssagesAccumulated = message;
        } else {
            if (!stringMesssagesAccumulated.equals(message)) {
                flush();
                stringMesssagesAccumulated = message;
            }
        }
        duplicatedStringMessagesCounter++;
    }

    public static void log(byte message) {
        if (byteMessagesAccumulated == null || (byteMessagesAccumulated + message > Byte.MAX_VALUE)) {
            flush();
            byteMessagesAccumulated = (int) message;
        } else {
            byteMessagesAccumulated += message;
        }
    }

    public static void log(boolean message) {
        flush();
        printMessage(decorate(PRIMITIVE_PREFIX, message));
    }

    private static void logArray(int[] message) {
        printMessage(decorate(PRIMITIVE_ARRAY_PREFIX, toString(message)));
    }

    private static String toString(int[] message) {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < message.length - 1; i++) {
            sb.append(message[i]).append(", ");
        }
        sb.append(message[message.length - 1]).append("}");
        return sb.toString();
    }

    private static String toString(int[][] message) {
        StringBuilder sb = new StringBuilder("{");
        for (int[] ints : message) {
            sb.append(lineSeparator()).append(toString(ints));
        }
        sb.append(lineSeparator()).append("}");
        return sb.toString();
    }

    public static void log(Object message) {
        flush();
        if (message instanceof int[]) {
            logArray((int[]) message);
        } else if (message instanceof int[][]) {
            logMatrix((int[][]) message);
        } else if (message instanceof int[][][][]) {
            logMatrix((int[][][][]) message);
        } else {
            printMessage(decorate(REFERENCE_PREFIX, message));
        }
    }

    private static void logMatrix(int[][][][] message) {
        StringBuilder sb = new StringBuilder("{").append(lineSeparator());
        for (int[][][] ints : message) {
            sb.append("{").append(lineSeparator());
            for (int[][] anInt : ints) {
                sb.append("{").append(lineSeparator());
                for (int[] ints1 : anInt) {
                    sb.append("{").append(lineSeparator());
                    for (int i : ints1) {
                        sb.append(i);
                    }
                    sb.append(lineSeparator()).append("}");
                }
                sb.append(lineSeparator()).append("}");
            }
            sb.append(lineSeparator()).append("}");
        }
        sb.append(lineSeparator()).append("}");
        printMessage(decorate(PRIMITIVE_MULTIMATRIX_PREFIX, sb.toString()));
    }

    private static void logMatrix(int[][] message) {
        printMessage(decorate(PRIMITIVE_MATRIX_PREFIX, toString(message)));
    }

    public static void flush() {
        if (ifIntCurrentState(intMessagesAccumulated)) {
            if (intMessagesAccumulated == Integer.MAX_VALUE) {
                printMessage(decorate(PRIMITIVE_PREFIX, "Integer.MAX_VALUE"));
            } else {
                printMessage(decorate(PRIMITIVE_PREFIX, intMessagesAccumulated));
            }
        }

        if (ifByteCurrentState(byteMessagesAccumulated)) {
            if (byteMessagesAccumulated == Byte.MAX_VALUE) {
                printMessage(decorate(PRIMITIVE_PREFIX, "Byte.MAX_VALUE"));
            } else {
                printMessage(decorate(PRIMITIVE_PREFIX, byteMessagesAccumulated));
            }
        }

        if (ifStringCurrentState(duplicatedStringMessagesCounter)) {
            if (duplicatedStringMessagesCounter == 1) {
                printMessage(decorate(STRING_PREFIX, stringMesssagesAccumulated));
            } else {
                printMessage(decorate(STRING_PREFIX, stringMesssagesAccumulated + " (x" + duplicatedStringMessagesCounter + ")"));
            }

        }
        intMessagesAccumulated = null;
        byteMessagesAccumulated = null;
        duplicatedStringMessagesCounter = 0;
    }


    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static String decorate(String stringPrefix, Object message) {
        return stringPrefix + message;
    }

    private static boolean ifIntCurrentState(Integer intMessagesAccumulated) {
        return intMessagesAccumulated != null;
    }

    private static boolean ifStringCurrentState(Integer stringMessagesRepeatCounter) {
        return stringMessagesRepeatCounter != 0;
    }

    private static boolean ifByteCurrentState(Integer byteMessagesAccumulated) {
        return byteMessagesAccumulated != null;
    }
}