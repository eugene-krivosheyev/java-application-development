package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        printMessage(decorate(message));
    }

    public static void log(byte message) {
        printMessage(decorate(message));
    }

    public static void log(char message) {
        printMessage(decorate(message));
    }

    public static void log(String message) {
        printMessage(decorate(message));
    }

    public static void log(boolean message) {
        printMessage(decorate(message));
    }

    public static void log(Object message) {
        printMessage(decorate(message));
    }

    private static String decorate(int message) {
        return "primitive: " + message;
    }

    private static String decorate(byte message) {
        return "primitive: " + message;
    }

    private static String decorate(char message) {
        return "char: " + message;
    }

    private static String decorate(String message) {
        return "string: " + message;
    }

    private static String decorate(boolean message) {
        return "primitive: " + message;
    }

    private static String decorate(Object message) {
        return "reference: " + message;
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
