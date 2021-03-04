package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {

        printIntToConsole(message);
    }

    public static void log(byte message) {

        printIntToConsole(message);
    }

    private static void printIntToConsole(int message) {
        System.out.println("primitive: " + message);
    }
}
