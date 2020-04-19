package com.acme.dbo.txlog;

public class LogControllerFactory {

    public static LogController create() {
        boolean isDecorated = Boolean.valueOf(System.getProperty("isDecorated", "false"));

        if (isDecorated) {
            return new DecoratedLogController(new ConsoleLogWriter(), new LogDecoratorImpl());
        } else {
            return new LogController(new ConsoleLogWriter());
        }
    }
}
