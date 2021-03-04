package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        printout(message);
    }

    public static void log(byte message) {
        printout(message);
    }

    private static void printout(int message) {
        System.out.println("primitive: " + message);
    }
}
