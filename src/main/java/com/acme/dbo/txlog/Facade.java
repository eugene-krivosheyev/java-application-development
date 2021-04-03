package com.acme.dbo.txlog;

import static java.lang.Math.abs;

public class Facade {
    public static final String PRIMITIVE = "primitive: ";
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";
    public static final String REFERENCE = "reference: ";
    public static final int INTEGER_TYPE = 1;
    public static final int BYTE_TYPE = 2;
    public static final int STRING_TYPE = 3;
    public static int lastType;
    public static String lastString;
    public static int accumulator;

    public static void checkTypeOverFlow(int message, int limit, String option) {
        if (abs(message) >= limit) {
            printToConsole(PRIMITIVE, limit);
        } else {
            switch (option) {
                case "Integer":
                    accumulator += message;
                    printToConsole(PRIMITIVE, accumulator);
                    break;
                case "Byte":
                    printToConsole(PRIMITIVE, message);
            }
        }
    }

    public static void log(int message) {
        if (lastType != INTEGER_TYPE) {
            flush();
        }
        checkTypeOverFlow(message, Integer.MAX_VALUE, "Integer");
        lastType = INTEGER_TYPE;
    }

    public static void log(byte message) {
        if (lastType != BYTE_TYPE) {
            flush();
        }
        checkTypeOverFlow(message, Byte.MAX_VALUE, "Byte");
        lastType = BYTE_TYPE;
    }

    public static void log(boolean message) {
        printToConsole(PRIMITIVE, message);
    }

    public static void log(char message) {
        printToConsole(CHAR, message);
    }

    public static void log(String message) {
        if ((lastType != STRING_TYPE) || (lastString != null && !message.equals(lastString))) {
            flush();
        }
        lastType = STRING_TYPE;
        lastString = message;
        accumulator++;
    }

    public static void log(Object message) {
        printToConsole(REFERENCE, message);
    }

    public static void printToConsole(String prefix, Object message) {
        System.out.println(prefix + message);
    }

    public static void flush() {
        switch (lastType) {
            case INTEGER_TYPE:
            case BYTE_TYPE:
                break;
            case STRING_TYPE:
                printToConsole(STRING, lastString + (accumulator == 1 ? "" : " (x" + accumulator + ")"));
                break;
        }
        accumulator = 0;
    }
}
