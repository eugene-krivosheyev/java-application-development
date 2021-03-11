package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        printMessage(message);
    }

    public static void log(char message) {
        printCharMessage(message);
    }

    public static void log(String message) {
        printStringMessage(message);
    }

    public static void log(byte message) {
        printMessage(message);
    }

    public static void log(boolean message) {
        printBooleanMessage(message);
    }

    public static void log(Object message) {
        printReferenceMessage(message);
    }

    private static void printMessage(int message) {
        System.out.println("primitive: " + message);
    }

    private static void printCharMessage(char message) {
        System.out.println("char: " + message);
    }

    private static void printStringMessage(String message) {
        System.out.println("string:  " + message);
    }

    private static void printBooleanMessage(boolean message) {
        System.out.println("primitive: " + message);
    }

    private static void printReferenceMessage(Object message) {
        System.out.println("reference:  " + message);
    }
}
