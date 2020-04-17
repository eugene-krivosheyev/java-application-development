package com.acme.dbo.txlog.controller;

import com.acme.dbo.txlog.command.Command;
import com.acme.dbo.txlog.command.NullCommand;
import com.acme.dbo.txlog.writer.LogWriter;

public class LoggerController {
    private LogWriter logWriter;
    private Command currentState = new NullCommand();

    public LoggerController(LogWriter logWriter) {
        this.logWriter = logWriter;
    }

    public void log(Command command) {
        if(sameCommand(command) && currentState.checkNoOverflow(command)) {
            updateState(command);
        } else {
            flush(command);
        }
    }

    private boolean sameCommand(Command command) {
        return currentState.isSame(command);
    }

    private void updateState(Command command) {
        currentState.accumulateCommand(command);
    }

    private void flush(Command command) {
        String message = currentState.decoratedMessage();
        if (!message.equals("")) {
            logWriter.write(message);
        }
        this.currentState = command;
    }

}
