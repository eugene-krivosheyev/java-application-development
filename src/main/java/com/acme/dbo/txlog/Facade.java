package com.acme.dbo.txlog;

public class Facade {

    private final static String PRIMITIVE_PREFIX = "primitive: ";

    public static void printMessage(String prefix, String message) {
        if (prefix.equals(PRIMITIVE_PREFIX)) { System.out.println(prefix + message);}
        else {System.out.println(prefix + message);}
    }

    public static void log(int message) {
        printMessage(PRIMITIVE_PREFIX, Integer.toString(message));
    }

    public static void log(byte message) {
        printMessage(PRIMITIVE_PREFIX, Byte.toString(message));
    }

    public static void log(char message) {
        printMessage("char: ", Character.toString(message));
    }

    public static void log(String message) {
        printMessage("string: ", message);
    }

    public static void log(boolean message) {
        printMessage(PRIMITIVE_PREFIX, Boolean.toString(message));
    }

    public static void log(Object message) { printMessage("reference: ", String.valueOf(message)); }
}
