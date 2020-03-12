package com.acme.dbo.txlog;

public class Facade {
    private static String PRIMITIVE_PREFIX = "primitive";

    public static void log(int i) {
        print(formatWithPrefix(PRIMITIVE_PREFIX, String.valueOf(i)));
    }

    public static void log(byte b) {
        print(formatWithPrefix(PRIMITIVE_PREFIX, String.valueOf(b)));
    }

    public static void log(boolean b) {
        print(formatWithPrefix(PRIMITIVE_PREFIX, String.valueOf(b)));
    }

    public static void log(char c) {
        print(formatWithPrefix("char", String.valueOf(c)));
    }

    public static void log(String s) {
        print(formatWithPrefix("string", s));
    }

    public static void log(Object o) {
        print(formatWithPrefix("reference", String.valueOf(o)));
    }

    private static String formatWithPrefix(String prefix, String subject) {
        return String.format("%s: %s", prefix, subject);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
