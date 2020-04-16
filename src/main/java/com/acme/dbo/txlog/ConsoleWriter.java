package com.acme.dbo.txlog;

import com.acme.dbo.txlog.command.LogCommand;

public class ConsoleWriter implements LogWriter {
    @Override
    public void write(LogCommand command) {
        if (command != null) {
            System.out.println(command.getPrefix() + ": " + command.getValue());
        }
    }
}
