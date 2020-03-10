package com.acme.dbo.txlog;

import static java.lang.String.valueOf;

public class Facade {
    public static void log(int message) {
        logPrimitive(valueOf(message));
    }

    public static void log(byte message) {
        logPrimitive(valueOf(message));
    }

    public static void log(char message) {
        logMessage("char: ", valueOf(message));
    }

    public static void log(String message) {
        logMessage("string: ", message);
    }

    public static void log(boolean message) {
        logPrimitive(valueOf(message));
    }

    public static void log(Object message) {
        logMessage("reference: ", message);
    }

    private static void logPrimitive(Object message) {
        logMessage("primitive: ", message);
    }

    private static void logMessage(String prefix, Object message) {
        System.out.println(prefix + message);
    }
}
