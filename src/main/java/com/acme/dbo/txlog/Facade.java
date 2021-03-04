package com.acme.dbo.txlog;

public class Facade {
    private static final String prefix = "primitive: ";

    public static void log(int message) {
        System.out.println(prefix + message);
    }

    public static void log(byte message) {
        System.out.println(prefix + message);
    }
}
