package com.acme.dbo.txlog.writers;

import com.acme.dbo.txlog.commands.Command;

public class ConsoleLogWriter implements LogWriter {
    @Override
    public void write(Command command) {
        System.out.println(command);
    }
}
