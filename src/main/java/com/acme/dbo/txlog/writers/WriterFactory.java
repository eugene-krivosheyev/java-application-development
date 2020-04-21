package com.acme.dbo.txlog.writers;

public class WriterFactory {
    public static LogWriter create() {
        return new ConsoleLogWriter();
    }
}
