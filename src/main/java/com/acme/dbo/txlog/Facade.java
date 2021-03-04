package com.acme.dbo.txlog;

public class Facade {
    private static final String primitivePrefix = "primitive: ";

    public static void log(int message) {
        printToConsole(primitivePrefix + message);
    }

    public static void log(byte message) {
        printToConsole(primitivePrefix + message);
    }

    private static void printToConsole(String message) {
	System.out.println(message);
    }
}
