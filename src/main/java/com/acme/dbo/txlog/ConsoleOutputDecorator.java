package com.acme.dbo.txlog;

public class ConsoleOutputDecorator {
    public static void sysPrimitiveOut(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void sysPrimitiveOut(String message) {
        System.out.println("primitive: " + message);
    }

    public static void sysPrimitiveOut(int message) {
        System.out.println("primitive: " + message);
    }

    public static void sysPrimitiveOut(float message) {
        System.out.println("primitive: " + message);
    }

    public static void sysPrimitiveOut(boolean message) {
        System.out.println("primitive: " + message);
    }
}
