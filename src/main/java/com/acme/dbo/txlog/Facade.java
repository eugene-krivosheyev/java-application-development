package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        logOutput("primitive: " + message);
    }

    public static void log(byte message) {
        logOutput("primitive: " + message);
    }

    public static void logOutput(String message) {
        System.out.print(message+"\n");
    }
}
