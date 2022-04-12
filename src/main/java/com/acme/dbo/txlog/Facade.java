package com.acme.dbo.txlog;

import com.acme.dbo.txlog.printer.ConsolePrinter;

import static com.acme.dbo.txlog.decorator.MessageDecorator.decorate;
import static com.acme.dbo.txlog.printer.ConsolePrinter.*;

public class Facade {
    public static void log(int message) {
        print(decorate(message));
    }

    public static void log(char message) {
        print(decorate(message));
    }

    public static void log(String message) {
        print(decorate(message));
    }

    public static void log(boolean message) {
        print(decorate(message));
    }

    public static void log(Object message) {
        print(decorate(message));
    }
}
