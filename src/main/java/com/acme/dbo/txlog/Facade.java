package com.acme.dbo.txlog;

public class Facade {

    private static final String PREFIX_REFERENCE = "reference";
    private static final String PREFIX_PRIMITIVE = "primitive";
    private static final String PREFIX_STRING = "string";
    private static final String PREFIX_CHAR = "char";

    private static void printToConsole(String message) {
        System.out.println(message);
    }

    private static String formatAsPrefixColonMessage(String prefix, String message) {
        return String.format("%s: %s", prefix, message);
    }

    public static void log(int message) {
        printToConsole(formatAsPrefixColonMessage(PREFIX_PRIMITIVE, String.valueOf(message)));
    }

    public static void log(byte message) {
        printToConsole(formatAsPrefixColonMessage(PREFIX_PRIMITIVE, String.valueOf(message)));
    }

    public static void log(char message) {
        printToConsole(formatAsPrefixColonMessage(PREFIX_CHAR, String.valueOf(message)));
    }

    public static void log(String message) {
        printToConsole(formatAsPrefixColonMessage(PREFIX_STRING, String.valueOf(message)));
    }

    public static void log(Boolean message) {
        printToConsole(formatAsPrefixColonMessage(PREFIX_PRIMITIVE, String.valueOf(message)));
    }

    public static void log(Object message) {
        printToConsole(formatAsPrefixColonMessage(PREFIX_REFERENCE, String.valueOf(message)));
    }
}
