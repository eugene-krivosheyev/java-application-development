package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.ConsoleOutputDecorator.decorateOutput;

public class Facade {
    public static void log(int message) {
        decorateOutput(message);
    }

    public static void log(byte message) {
        decorateOutput(message);
    }

    public static void log(char message) {
        decorateOutput(message);
    }

    public static void log(boolean message) {
        decorateOutput(message);
    }

    public static void log(Object message) {
        decorateOutput(message);
    }

    public static void log(String message) {
        decorateOutput(message);
    }
}
