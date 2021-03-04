package com.acme.dbo.txlog;

public class Facade {
    //TODO: change to enum or dictionary
    private static final String PrefixMessagePrimitive = "primitive: ";
    private static final String PrefixMessageChar = "char: ";
    private static final String PrefixMessageString = "string: ";
    private static final String PrefixMessageReference = "reference: ";

    private static void PrintMessage(String Richmessage) {
        System.out.println(Richmessage);
    }

    public static void log(int message) {
        PrintMessage(PrefixMessagePrimitive + message);
    }

    public static void log(byte message) {
        PrintMessage(PrefixMessagePrimitive + message);
    }

    public static void log(char message) {
        PrintMessage(PrefixMessageChar + message);
    }

    public static void log(String message) {
        PrintMessage(PrefixMessageString + message);
    }
    public static void log(boolean message) {
        PrintMessage(PrefixMessagePrimitive + message);
    }

    public static void log(Object message) {
        PrintMessage(PrefixMessageReference + message);
    }
}
