package com.acme.dbo.txlog;

public class Facade {
    String separator = "primitive: ";

    public static void writeToConsole(String separator,String message)
    {
        System.out.println(separator + message);
    }

    public static void log(int message) {
       String separator = "primitive: ";
        writeToConsole (separator, Integer.toString(message));
    }

    public static void log(byte message) {
        System.out.println("primitive: " + Byte.toString(message));
    }
}
