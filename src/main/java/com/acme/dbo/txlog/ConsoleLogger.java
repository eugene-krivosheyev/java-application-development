package com.acme.dbo.txlog;

public class ConsoleLogger implements Logger {
    public void log(Object message) {
        System.out.println(message);
    }
}
