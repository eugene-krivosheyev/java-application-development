package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        printMessage(message);
    }


    public static void log(byte message) {
        printMessage(message);
    }

    private static void printMessage(int message) {
        System.out.println("primitive: " + message);
    }
}
