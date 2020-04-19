package com.acme.dbo.txlog;

public class ConsoleLogWriter implements LogWriter {

    @Override
    public void write(Command command) {
        System.out.println(command);
    }

    @Override
    public void write(String command) {
        System.out.println(command);
    }

}
