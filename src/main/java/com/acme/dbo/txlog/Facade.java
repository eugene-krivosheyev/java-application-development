package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        printToConsole(decorate(message));
    }

    public static void log(byte message) {
        printToConsole(decorate(message));
    }

    public static void log(char message) {
        printToConsole(decorate(message));
    }

    public static void log(String message) {
        printToConsole(decorate(message));
    }

    public static void log(boolean message) {
        printToConsole(decorate(message));
    }

    public static void log(Object message) {
        printToConsole(decorate(message));
    }

    private static String decorate(int message) {
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

    private static void printToConsole(String message) {
        System.out.println(message);
    }
}
