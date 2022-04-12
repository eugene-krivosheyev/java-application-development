package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.decorator.MessageDecorator.decorate;
import static com.acme.dbo.txlog.printer.ConsolePrinter.print;

public class Facade<T> {
    public static <T> void log(T message) {
        print(decorate(message));
    }
}
