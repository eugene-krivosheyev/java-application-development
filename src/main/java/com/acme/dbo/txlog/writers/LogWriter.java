package com.acme.dbo.txlog.writers;

public class LogWriter implements Writer {
    public void write(String message) {
        System.out.println(message);
    }
}
