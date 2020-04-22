package com.acme.dbo.txlog.controllers;

import com.acme.dbo.txlog.commands.BaseCommand;
import com.acme.dbo.txlog.commands.Command;
import com.acme.dbo.txlog.writers.Writer;
import com.acme.dbo.txlog.writers.WriteException;

public class LoggerTypedController {
    private Writer writer;

    private Command state;

    public LoggerTypedController(Writer writer) {
        this.writer = writer;
        state = BaseCommand.EMPTY_COMMAND;
    }

    public void log(Command command) {
        if (command.shouldAppend(state)) {
            state = command.append(state);
        } else {
            try {
                writer.write(state.getDecoratedMessage());
            } catch (WriteException e){
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
            state = command;
        }
    }
}
