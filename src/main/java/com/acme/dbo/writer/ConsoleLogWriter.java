package com.acme.dbo.writer;

public class ConsoleLogWriter implements LogWriter {

    @Override
    public void write (String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
