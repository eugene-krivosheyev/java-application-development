package com.acme.dbo.txlog;

import java.io.PrintStream;

public class Facade {

    private static PrintStream writer = System.out;

    public static void log(byte message) {
        logPrimitive(Byte.toString(message));
    }

    public static void log(int message) {
        logPrimitive(Integer.toString(message));
    }

    public static void log(boolean message) {
        logPrimitive(Boolean.toString(message));
    }

    public static void log(char message) {
        logPrefix("char", Character.toString(message));
    }

    public static void log(String message) {
        logPrefix("string", message);
    }

    public static void log(Object message) {
        logPrefix("reference", message.toString());
    }

    private static void logPrimitive(String message){
        writer.println("primitive: " + message);
    }

    private static void logPrefix(String prefix, String message){
        writer.println(prefix + ": " + message);
    }
}
