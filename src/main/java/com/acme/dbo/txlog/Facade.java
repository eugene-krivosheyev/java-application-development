package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.decorator.MessageDecorator.appendLogValue;
import static com.acme.dbo.txlog.decorator.MessageDecorator.getLoggerContent;
import static com.acme.dbo.txlog.printer.ConsolePrinter.print;

public class Facade {
    public static void log(Object obj) {
        appendLogValue(obj);
    }
    public static void flush() { print(getLoggerContent());
    }
}