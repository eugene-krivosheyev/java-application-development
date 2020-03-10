package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        System.out.println("primitive: " + message);
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void log(char message) {
        System.out.println(String.format("char: %s", message));
    }

    public static void log(String message) {
        System.out.println(String.format("string: %s", message));
    }

    public static void log(Boolean message) {
        System.out.println(String.format("primitive: %s", message));
    }

    public static void log(Object message) {
        System.out.println(String.format("reference: @"));
    }
}
