package com.acme.dbo.txlog;

public class Facade {

    public static final String PRIMITIVE = "primitive: ";
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";
    public static final String REFERENCE = "reference: ";

    public static void log(int message) {
        printLog(PRIMITIVE, message);
    }

    public static void log(byte message) {
        printLog(PRIMITIVE, message);
    }
    public static void log(char message) {
        printLog(CHAR, message);
    }
    public static void log(String message) {
        printLog(STRING, message);
    }

    public static void log(boolean message) {
        printLog(PRIMITIVE, message);
    }

    public static void log(Object message) {
        printLog(REFERENCE, message);
    }

    private static void printLog(String prefix, Object message) {
        System.out.println(prefix + message);
    }


}
