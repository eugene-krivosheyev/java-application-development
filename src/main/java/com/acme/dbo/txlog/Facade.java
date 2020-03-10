package com.acme.dbo.txlog;

public class Facade {

    final static String PRIMITIVE = "primitive";
    final static String STRING = "string";
    final static String CHAR = "char";
    final static String REFERENCE = "reference";

    public static void log(int message) {
        print(decorate(PRIMITIVE, message));
    }

    public static void log(byte message) {
        print(decorate(PRIMITIVE, message));
    }

    public static void log(char message) {
        print(decorate(CHAR, message));
    }

    public static void log(String message) {
        print(decorate(STRING, message));
    }

    public static void log (boolean message) {
        print(decorate(PRIMITIVE, message));
    }

    public static void log (Object message) {
        print(decorate(REFERENCE, message));
    }

    public static String decorate (String type, Object value) {
        return (type + ": " + value.toString());
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
