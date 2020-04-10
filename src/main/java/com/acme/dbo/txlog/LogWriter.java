package com.acme.dbo.txlog;

public class LogWriter {
    public void write(Command command) {
        System.out.println(command.decorate(command));
    }
}