package com.acme.dbo.txlog;

public class Facade {

    public static final String PRIMITIVE_PREFIX = "primitive: ";

    public static void log(int message) {
        logOutput(message);
    }

    public static void log(byte message) {
        logOutput(message);
    }

    public static void logOutput(int message) {
        System.out.println(PRIMITIVE_PREFIX +message);
    }
}
