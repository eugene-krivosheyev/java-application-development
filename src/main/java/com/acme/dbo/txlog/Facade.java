package com.acme.dbo.txlog;

public class Facade {
    static String PrefixMessagePrimitive = "primitive: ";
    static String PrefixMessageChar = "char: ";
    static String PrefixMessageString = "string: ";
    static String PrefixMessageReference = "reference: ";

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
