package com.acme.dbo.txlog;

public class Facade {
    public static final String PRIMITIVE = "primitive: ";
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";
    public static final String REFERENCE = "reference: ";


    public static void log(int message) {
        printToConsole(PRIMITIVE, message);
    }

    public static void log(byte message) {
        printToConsole(PRIMITIVE, message);
    }

    public static void log(boolean message) {
        printToConsole(PRIMITIVE, message);
    }

    public static void log(char message) {
        printToConsole(CHAR, message);
    }

    public static void log(String message) {
        printToConsole(STRING, message);
    }

    public static void log(Object message) {
        printToConsole(REFERENCE, message);
    }

        public static void printToConsole(String prefix, Object message) {
        System.out.println(prefix + message);
    }
}
