package com.acme.dbo.txlog.writers;

public interface LogWriter {
    void write(String message);
}