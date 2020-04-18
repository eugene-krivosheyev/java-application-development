package com.acme.dbo.txlog.writers;

public class ConsoleLogWriter implements LogWriter {
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}