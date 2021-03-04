package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        print(message);
    }

    public static void log(byte message) {
        print(message);
    }

    private static void print(Object message) {
        if (message instanceof Integer || message instanceof Byte) {
            prntPrimitive(message);
        }
    }

    private static void prntPrimitive(Object message) {
        prntToConsole("primitive: " + message);
    }

    private static void prntToConsole(Object message) {
        System.out.println(message);
    }
}
