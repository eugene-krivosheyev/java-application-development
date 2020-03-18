package com.acme.dbo.txlog;

public class Facade {

    private static void decorateLogPrimitive(String message) {
        System.out.println("primitive: " + message);
    }

    public static void log(int message) {
        Facade.decorateLogPrimitive(String.valueOf(message));
    }

    public static void log(boolean message) {
        Facade.decorateLogPrimitive(String.valueOf(message));
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String message) {
        System.out.println("string: " + message);
    }

    public static void log(Object message) {
        System.out.println("reference: " + message);
    }
}
