package com.acme.dbo.txlog.writers;

public class LogWriterFactory {
    public static LogWriter create() {
        return new ConsoleLogWriter();
    }
}
