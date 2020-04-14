package com.acme.dbo.txlog.writers;

import com.acme.dbo.txlog.commands.Command;

public class LogWriter {
    public void write(Command command) {
        System.out.println(command.getDecoratedMessage());
    }
}
