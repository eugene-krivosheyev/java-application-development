package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Printer.printMessage;

public class Facade {
    //TODO: extract constants (prefixes) in decorator
    /*public static void log(int message) {
        printMessage(message);
    }

    public static void log(byte message) {
        printMessage(message);
    }

    public static void log(char message) {
        printMessage(message);
    }

    public static void log(String message) {
        printMessage(message);
    }

    public static void log(boolean message) {
        printMessage(message);
    }*/

    public static void log(Object message) {
        printMessage(message);
    }

}