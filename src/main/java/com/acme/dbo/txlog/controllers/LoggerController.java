package com.acme.dbo.txlog.controllers;

import com.acme.dbo.txlog.commands.Command;
import com.acme.dbo.txlog.commands.NullCommand;
import com.acme.dbo.txlog.writers.LogWriter;

public class LoggerController {
    private final LogWriter logWriter;
    private Command currentCommand;

    public LoggerController(LogWriter logWriter) {
        this.currentCommand = new NullCommand();
        this.logWriter = logWriter;
    }

    public void log(Command command) {
        try {
            currentCommand = currentCommand.accumulate(command);
        } catch (Exception e) {
            this.flush(command);
        }
    }

    public void flush() {
        flush(new NullCommand());
    }

    private void flush(Command command) {
        if (!(this.currentCommand instanceof NullCommand)) {
            logWriter.write(this.currentCommand);
        }
        this.currentCommand = command;
    }
}
