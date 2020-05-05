package com.acme.dbo.txlog.controllers;

import com.acme.dbo.txlog.commands.NullCommand;
import com.acme.dbo.txlog.exceptions.LoggingException;
import com.acme.dbo.txlog.exceptions.WriteException;
import com.acme.dbo.txlog.writers.LogWriter;
import com.acme.dbo.txlog.commands.Command;

public class LogController {
    private final String loggingExceptionMessage = "Logging error detected";
    private final LogWriter writer;
    private Command lastCommand = new NullCommand();

    public LogController(LogWriter logWriter) {
        this.writer = logWriter;
    }

    public void log(Command command) throws LoggingException {
        try {
            if (sameCommand(command)) {
                updateState(command);
            } else {
                flush(command);
            }
        } catch (Exception e){
            throw new LoggingException(loggingExceptionMessage, e.getCause());
        }
    }

    public void close() throws LoggingException {
        try {
            flush(new NullCommand());
        } catch (Exception e) {
            throw new LoggingException(loggingExceptionMessage, e.getCause());
        }
    }

    private void flush(Command command) throws WriteException {
        writer.write(lastCommand.getDecoratedMessage());
        lastCommand = command;
    }

    private void updateState(Command command) throws WriteException {
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
