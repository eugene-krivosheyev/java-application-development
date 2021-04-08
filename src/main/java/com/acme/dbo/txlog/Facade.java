package com.acme.dbo.txlog;

import ooaddemo.controller.LoggerController;
import ooaddemo.message.ByteMessage;
import ooaddemo.message.IntMessage;
import ooaddemo.message.StringMessage;
import ooaddemo.printer.ConsolePrinter;

import java.util.Arrays;

import static java.lang.System.lineSeparator;

public class Facade {

    public static LoggerController controller = new LoggerController(new ConsolePrinter());

    public enum Types {
        INT,
        BYTE,
        STRING,
        OBJECT
    }
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String PRIMITIVES_ARRAY_PREFIX = "primitives array: ";
    public static final String PRIMITIVES_MATRIX_PREFIX = "primitives matrix: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    private static long intState = 0;
    private static int byteState = 0;

    private static String stringState = "";
    private static int stringSubsequentCount = 0;

    public static void log(int message) {
        flushAllTypesExcept(Types.INT);
        intState += message;
        if(intState >= Integer.MAX_VALUE) {
            intState = Integer.MAX_VALUE;
        }
        controller.log(new IntMessage((int) intState));
    }

    public static void log(byte message) {
        flushAllTypesExcept(Types.BYTE);
        byteState += message;
        if(byteState >= Byte.MAX_VALUE) {
            byteState = Byte.MAX_VALUE;
        }
        controller.log(new ByteMessage((byte) byteState));
    }

    public static void log(String message) {
        flushAllTypesExcept(Types.STRING);
        if(!stringState.equals(message)) {
            flushType(Types.STRING);
            stringState = message;
        }
        stringSubsequentCount++;
        if(stringSubsequentCount > 1) {
            message = message + " (x" + stringSubsequentCount + ")";
        }
        controller.log(new StringMessage(message));
    }


    /*
    * Not refactored
     */

    public static void log(char message) {
        printToConsole(decorate(message, CHAR_PREFIX, ""));
    }

    public static void log(boolean message) {
        printToConsole(decorate(message, PRIMITIVE_PREFIX, ""));
    }

    public static void log(Object message) {
        printToConsole(decorate(message, REFERENCE_PREFIX, ""));
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

    public static void log(int... messages) {
        String sb = buildPrimitivesArrayOutput(messages);
        printToConsole(decorate(sb, PRIMITIVES_ARRAY_PREFIX, ""));
    }

    public static void log(String... messages) {
        String sb = buildGenericsArrayOutput(messages, lineSeparator());
        printToConsole(decorate(sb, "", ""));
    }

    public static void flushAllTypes() {
        for (Types t: Types.values()) {
            flushType(t);
        }
    }

    private static void flushType(Types type) {
        switch (type) {
            case INT:
                intState = 0;
                break;
            case BYTE:
                byteState = 0;
                break;
            case STRING:
                stringSubsequentCount = 0;
                stringState = "";
                break;
            default:
                break;
        }
    }

    private static void flushAllTypesExcept(Types type) {
        for (Types t: Types.values()) {
            if(t == type) {
                continue;
            }
            flushType(t);
        }
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
