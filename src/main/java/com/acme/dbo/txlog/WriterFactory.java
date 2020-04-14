package com.acme.dbo.txlog;

public class WriterFactory {
    public static LogWriter create() {
        return new ConsoleLogWriter();
    }
}
