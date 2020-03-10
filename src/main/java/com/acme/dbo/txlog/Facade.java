package com.acme.dbo.txlog;

public class Facade {
    private static void print(String type, String message) {
        System.out.println(format(type, message));
    }

    private static String format(String ...input) {
        return String.format("%s: %s", input[0], input[1]);
    }

    public static void log(int message) {
        print("primitive", String.valueOf(message));
    }

    public static void log(byte message) {
        print("primitive", String.valueOf(message));
    }

    public static void log(char message) {
        print("char", String.valueOf(message));
    }

    public static void log(String message) {
        print("string", String.valueOf(message));
    }

    public static void log(Boolean message) {
        print("primitive", String.valueOf(message));
    }

    public static void log(Object message) {
        print("reference", String.valueOf(message));
    }
}
