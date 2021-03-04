package com.acme.dbo.txlog;

public class ConsoleOutput {
    public static <T> void sysOut(T message) {
        System.out.println("primitive: " + message);
    }
}
