package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.OutputDecorator.logOutput;

public class Facade {


    public static void log(int message) {
        logOutput(message);
    }

    public static void log(char message) {
        logOutput(message);
    }

    public static void log(String message) {
        logOutput(message);
    }

    public static void log(Object message) {
        logOutput(message);
    }

    public static void log(boolean message) {
        logOutput(message);
    }


}
