package com.acme.dbo.txlog;

import java.util.Arrays;

import static java.lang.System.lineSeparator;

public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String PRIMITIVES_ARRAY_PREFIX = "primitives array: ";
    public static final String PRIMITIVES_MATRIX_PREFIX = "primitives matrix: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";
    private static final String PRIMITIVE_POSTFIX = "";
    private static final String CHAR_POSTFIX = "";
    private static final String STRING_POSTFIX = "";
    private static final String REFERENCE_POSTFIX = "";

    private static long intState = 0;
    private static int byteState = 0;

    private static String stringState = "";
    private static int stringSubsequentCount = 0;

    public static void log(int message) {
        flushString();
        flushByte();
        intState += message;
        if(intState >= Integer.MAX_VALUE) {
            intState = Integer.MAX_VALUE;
        }
        printToConsole(decorate(intState, PRIMITIVE_PREFIX, PRIMITIVE_POSTFIX));
    }

    public static void log(byte message) {
        flushString();
        flushInt();
        byteState += message;
        if(byteState >= Byte.MAX_VALUE) {
            byteState = Byte.MAX_VALUE;
        }
        printToConsole(decorate(byteState, PRIMITIVE_PREFIX, PRIMITIVE_POSTFIX));
    }

    public static void log(char message) {
        printToConsole(decorate(message, CHAR_PREFIX, CHAR_POSTFIX));
    }

    public static void log(String message) {
        flushInt();
        flushByte();
        if(!stringState.equals(message)) {
            flushString();
            stringState = message;
        }
        stringSubsequentCount++;
        if(stringSubsequentCount > 1) {
            message = message + " (x" + stringSubsequentCount + ")";
        }
        printToConsole(decorate(message, STRING_PREFIX, STRING_POSTFIX));
    }

    public static void log(boolean message) {
        printToConsole(decorate(message, PRIMITIVE_PREFIX, PRIMITIVE_POSTFIX));
    }

    public static void log(Object message) {
        printToConsole(decorate(message, REFERENCE_PREFIX, REFERENCE_POSTFIX));
    }

    public static void log(int[] messages) {
        String sb = buildPrimitivesArrayOutput(messages);
        printToConsole(decorate(sb, PRIMITIVES_ARRAY_PREFIX, ""));
    }

    public static void log(int[][] messagesMatrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(lineSeparator());
        for (int[] ints : messagesMatrix) {
            sb.append(buildPrimitivesArrayOutput(ints));
            sb.append(lineSeparator());
        }
        sb.append("}");
        printToConsole(decorate(sb,PRIMITIVES_MATRIX_PREFIX,""));
    }

    public static void log(String... messages) {
        String sb = buildGenericsArrayOutput(messages, lineSeparator());
        printToConsole(decorate(sb, "", ""));
    }

    public static void log(Integer... messages) {
        String sb = buildGenericsArrayOutput(messages, "");
        printToConsole(decorate(sb, "", ""));
    }

    public static void flushInt() {
        intState = 0;
    }

    public static void flushByte() {
        byteState = 0;
    }

    public static void flushString() {
        stringSubsequentCount = 0;
        stringState = "";
    }

    public static void flush() {
        flushInt();
        flushByte();
        flushString();
    }

    private static void printToConsole(Object message) {
        System.out.println(message);
    }

    private static String buildPrimitivesArrayOutput(int[] message) {
        Integer[] array = Arrays.stream( message ).boxed().toArray( Integer[]::new );
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(buildGenericsArrayOutput(array, ", "));
        sb.append("}");
        return sb.toString();
    }

    private static<T> String buildGenericsArrayOutput(T[] messages, String separator) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < messages.length; i++) {
            sb.append(messages[i]);
            if(i != messages.length - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    private static String decorate(Object message, String prefix, String postfix) {
        return prefix + message + postfix;
    }
}
