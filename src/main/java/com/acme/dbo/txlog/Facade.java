package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        printToConsole(decorate(message));
    }

    public static void log(byte message) {
        printToConsole(decorate(message));
    }

    private static String decorate(Object message) {
        return "primitive: " + message;
    }

    private static void printToConsole(Object message) {
        System.out.println(message);
    }
}
