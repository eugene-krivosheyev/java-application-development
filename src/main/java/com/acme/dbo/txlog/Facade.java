package com.acme.dbo.txlog;

public class Facade {

    public static void printMessage(String prefix, String message) {
        System.out.println(prefix + message);
    }

    public static void log(int message) {
        printMessage("primitive: ", Integer.toString(message));
    }

    public static void log(byte message) {
        printMessage("primitive: ", Byte.toString(message));
    }

    public static void log(char message) {
        printMessage("char: ", Character.toString(message));
    }

    public static void log(String message) {
        printMessage("string: ", message);
    }

    public static void log(boolean message) {
        printMessage("primitive: ", Boolean.toString(message));
    }

    public static void log(Object message) { printMessage("reference: ", String.valueOf(message)); }
}
