package com.acme.dbo.txlog;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
