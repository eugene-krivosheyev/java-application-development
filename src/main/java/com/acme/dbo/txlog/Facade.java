package com.acme.dbo.txlog;

public class Facade {

    public static void printMessage(String message) {
        System.out.println("primitive: " + message);
    }

    public static void log(int message) {
        printMessage(Integer.toString(message));
    }

    public static void log(byte message) {
        printMessage(Byte.toString(message));
    }
}
