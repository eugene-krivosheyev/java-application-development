package com.acme.dbo.txlog.writers;

import java.util.Objects;

public class ConsoleLogWriter implements LogWriter {
    @Override
    public void write(String message) {
        if (Objects.nonNull(message)) System.out.println(message);
    }
}