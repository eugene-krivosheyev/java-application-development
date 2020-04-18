package com.acme.dbo.txlog.controllers;

import com.acme.dbo.txlog.writers.LogWriter;
import com.acme.dbo.txlog.commands.Command;

import java.util.Objects;

public class LogController {

    private LogWriter writer;
    private Command lastCommand = null;

    public LogController(LogWriter logWriter) {
        this.writer = logWriter;
    }

    public void log(Command command) {
        if (Objects.isNull(lastCommand)) {
            lastCommand = command;
        } else if (sameCommand(command)) {
            updateState(command);
        } else {
            flush(command);
        }
    }

    public void close() {
        if (! Objects.isNull(lastCommand)) {
            writer.write(lastCommand.getDecoratedMessage());
        }
        lastCommand = null;
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
