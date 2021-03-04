package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        prntPrimitive(message);
    }

    public static void log(byte message) {
        prntPrimitive(message);
    }

    private static void prntPrimitive(Object message) {
        prntToConsole("primitive: " + message);
    }

    private static void prntToConsole(Object message) {
        System.out.println(message);
    }
}
