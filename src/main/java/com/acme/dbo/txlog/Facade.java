package com.acme.dbo.txlog;

public class Facade {
    public static void log(Object message) {
        System.out.println("primitive: " + message);
    }
}
