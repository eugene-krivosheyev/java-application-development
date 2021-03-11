package com.acme.dbo.txlog;

import static java.lang.System.*;

public class Facade {
    public static void log(int message) {
        printToConsole("primitive: " + message);
    }

    public static void log(byte message) {
        printToConsole("primitive: " + String.valueOf(message));
    }

    public static void log(char message) {
        printToConsole("char: " + message);
    }

    public static void log(String message) {
        printToConsole("string: " + message);
    }

    public static void log(boolean message) {
        printToConsole("primitive: " + message);
    }

    public static void log(Object message) {
        printToConsole("reference: " + message);
    }

    private static void printToConsole(String message) {
        out.println(message);
    }


}
