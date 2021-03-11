package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        print("primitive: " + message);
    }

    public static void log(byte message) {
        print("primitive: " + message);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
