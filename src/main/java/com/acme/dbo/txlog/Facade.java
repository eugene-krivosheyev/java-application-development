package com.acme.dbo.txlog;

public class Facade {

    public static final String PRIMITIVE = "primitive: ";

    public static void log(int message) {
        printLog(message);
    }

    public static void log(byte message) {
        printLog(message);
    }

    private static void printLog(int message) {
        System.out.println(PRIMITIVE + message);
    }
}
