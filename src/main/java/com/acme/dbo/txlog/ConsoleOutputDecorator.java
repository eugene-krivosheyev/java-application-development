package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Logger.consoleLog;

public class ConsoleOutputDecorator {
    public static void decorateOutput(byte message) {
        consoleLog("primitive: " + message);
    }

    public static void decorateOutput(String message) {
        consoleLog("string: " + message);
    }

    public static void decorateOutput(char message) {
        consoleLog("char: " + message);
    }

    public static void decorateOutput(int message) {
        consoleLog("primitive: " + message);
    }

    public static void decorateOutput(float message) {
        consoleLog("primitive: " + message);
    }

    public static void decorateOutput(boolean message) {
        consoleLog("primitive: " + message);
    }

    public static void decorateOutput(Object message) {
        consoleLog("reference: " + message);
    }
}
