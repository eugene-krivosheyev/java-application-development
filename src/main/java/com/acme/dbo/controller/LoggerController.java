package com.acme.dbo.controller;

import com.acme.dbo.command.Command;
import com.acme.dbo.writer.LogWriter;

public class LoggerController {
    private LogWriter logWriter;
    private Command currentState;

    public LoggerController(LogWriter logWriter) {
        this.logWriter = logWriter;
    }

    public void log(Command command) {
        if(currentState == null) {
            this.currentState = command;
            return;
        }
        if(sameCommand(command) && currentState.checkOverflow(command)) {
            updateState(command);
        } else {
            flush(command);
        }
    }

    private boolean sameCommand(Command command) {
        return currentState.isSame(command);
    }

    private void updateState(Command command) {
        this.currentState = currentState.accumulateCommand(command);
    }

    private void flush(Command command) {
        String message = currentState.decoratedMessage();
        if (message != null) {
            logWriter.write(message);
        }
        this.currentState = command;
    }

}
