package com.acme.dbo.txlog.writers;

import com.acme.dbo.txlog.exceptions.WriteException;

public interface LogWriter {
    void write(String message) throws WriteException;
}