package com.acme.dbo.txlog;

public class Facade {
    private static final String primitivePrefix = "primitive: ";
    private static final String primitiveCharPrefix = "char: ";
    private static final String primitiveStringPrefix = "string: ";
    private static final String primitiveReferencePrefix = "reference: ";

    /**
       Print to console int and byte.
     */
    public static void log(int message) {
        printToConsole(primitivePrefix + message);
    }

    public static void log(boolean b) {
        printToConsole(primitivePrefix + b);
    }

    public static void log(char c) {
        printToConsole(primitiveCharPrefix + c);
    }

    public static void log(String s) {
        printToConsole(primitiveStringPrefix + s);
    }

    public static void log(Object obj) {
        printToConsole(primitiveReferencePrefix + obj);
    }

    private static void printToConsole(String message) {
	System.out.println(message);
    }
}
