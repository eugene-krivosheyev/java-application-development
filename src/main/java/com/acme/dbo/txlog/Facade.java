package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        printMessage("primitive: " + message);
    }

    public static void log(char message) {
        printMessage("char: " + message);
    }

    public static void log(String message) {
        printMessage("string: " + message);
    }

    public static void log(boolean message) {
        printMessage("primitive: " + message);
    }

    public static void log(Object obj) {
        printMessage("reference: " + obj);
    }


    private static void printMessage(String msg) {
        System.out.println(msg);
    }
}
