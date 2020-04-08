package com.acme.dbo.txlog;

import com.acme.dbo.txlog.commands.Command;

public class LoggerTypedController {
    LogWriter writer;

    private Command commandState;

    public LoggerTypedController(LogWriter writer) {
        this.writer = writer;
    }

    public void log(Command command) {
        Command newState = command.append(commandState);
        if (newState != null) {
            commandState = newState;
        } else {
            close();
        }
        if(commandState == null) {
            commandState = command;
        }
    }

    public void close() {
        if (commandState != null) {
            writer.write(commandState.getDecoratedMessage());
            commandState = null;
        }
    }
}