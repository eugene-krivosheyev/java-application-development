package com.acme.dbo.txlog.writers;

public class ConsoleWriter implements Writer {
    public void write(String message) throws WriteException {
        System.out.println(message);
    }
}
