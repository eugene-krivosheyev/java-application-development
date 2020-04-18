package com.acme.dbo.txlog.controllers;

import com.acme.dbo.txlog.commands.NullCommand;
import com.acme.dbo.txlog.writers.LogWriter;
import com.acme.dbo.txlog.commands.Command;

public class LogController {

    private final LogWriter writer;
    private Command lastCommand = new NullCommand();

    public LogController(LogWriter logWriter) {
        this.writer = logWriter;
    }

    public void log(Command command) {
        if (sameCommand(command)) {
            updateState(command);
        } else {
            flush(command);
        }
    }

    public void close() {
        flush(new NullCommand());
    }

    private void flush(Command command) {
        writer.write(lastCommand.getDecoratedMessage());
        lastCommand = command;
    }

    private void updateState(Command command) {
        if (lastCommand.validate(command)) {
            lastCommand.accumulate(command);
        } else {
            flush(command);
        }
    }

    private boolean sameCommand(Command command) {
        return lastCommand.isSame(command);
    }
}
