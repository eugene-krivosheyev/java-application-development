package com.acme.dbo.txlog;

public class Facade {
    //TODO: change to enum or dictionary
    private static final String PrefixMessagePrimitive = "primitive: ";
    private static final String PrefixMessageChar = "char: ";
    private static final String PrefixMessageString = "string: ";
    private static final String PrefixMessageReference = "reference: ";

    private static void printMessage(String Richmessage) {
        System.out.println(Richmessage);
    }

    public static void log(int message) {
        printMessage(PrefixMessagePrimitive + message);
    }

    public static void log(byte message) {
        printMessage(PrefixMessagePrimitive + message);
    }

    public static void log(char message) {
        printMessage(PrefixMessageChar + message);
    }

    public static void log(String message) {
        printMessage(PrefixMessageString + message);
    }
    public static void log(boolean message) {
        printMessage(PrefixMessagePrimitive + message);
    }

    public static void log(Object message) {
        printMessage(PrefixMessageReference + message);
    }
}
