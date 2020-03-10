package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        write("primitive", String.valueOf(message));
    }

    public static void log(byte message) {
        write("primitive", String.valueOf(message));
    }

    public static void log(boolean message){
        write("primitive", String.valueOf(message));;
    }

    public static void log(Object message){
        write("reference", String.valueOf(message));
    }

    public static void log(char message){
        write("char", String.valueOf(message));
    }

    public static void log(String message){
        write("string", String.valueOf(message));
    }

    private static void write(String prefix, String payload) {
        System.out.println(prefix + ": " + payload);
    }
}
