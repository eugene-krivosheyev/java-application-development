package com.acme.dbo.txlog.writers;

import com.acme.dbo.txlog.exceptions.WriteException;

import java.util.Objects;

public class ConsoleLogWriter implements LogWriter {
    @Override
    public void write(String message) throws WriteException {
        try {
            if (Objects.nonNull(message)) {
                System.out.println(message);
            }
        } catch (Exception e) {
            throw new WriteException(e.getMessage(), e.getCause());
        }
    }
}