package com.acme.dbo.txlog;

public class Facade {

    private static void primitiveLogger(Object o) {
        System.out.println("primitive: " + o.toString());
    }

    private static void referenceLogger(Object o) {
        System.out.println("reference: " + o.toString());
    }

    private static void charLogger(char c) {
        System.out.println("char: " + c);
    }

    private static void stringLogger(String s) {
        System.out.println("string: " + s);
    }

    public static void log(int message) {
        primitiveLogger(message);
    }

    public static void log(byte message) {
        primitiveLogger(message);
    }

    public static void log(boolean message) {
        primitiveLogger(message);
    }

    public static void log(Object o) {
        referenceLogger(o);
    }

    public static void log(char c) {
        charLogger(c);
    }

    public static void log(String s) {
        stringLogger(s);
    }


}
