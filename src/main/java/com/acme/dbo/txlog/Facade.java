package com.acme.dbo.txlog;

public class Facade {
    public static boolean isDecorated;

    private static void decorateLogPrimitive(String message) {
        if (Facade.isDecorated) {
            System.out.println("primitive: " + message);
        } else {
            System.out.println(message);
        }
    }

    public static void log(int message) {
        Facade.decorateLogPrimitive(String.valueOf(message));
    }

    public static void log(boolean message) {
        Facade.decorateLogPrimitive(String.valueOf(message));
    }

    public static void log(char message) {
        if (Facade.isDecorated) {
            System.out.println("char: " + message);
        } else {
            System.out.println(message);
        }
    }

    public static void log(String message) {
        if (Facade.isDecorated) {
            System.out.println("string: " + message);
        } else {
            System.out.println(message);
        }
    }

    public static void log(Object message) {
        System.out.println("reference: " + message);
    }
}
