package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Decorator.decorate;

public class Printer {

    static void printMessage(Object message) {
        printToConsole(decorate(message));
    }

    private static void printToConsole(Object message) {
        System.out.println(message);
    }
}
