package com.acme.dbo.txlog.controllers;

import com.acme.dbo.txlog.commands.Command;

import com.acme.dbo.txlog.writers.Writer;

public class LoggerTypedController {
    private Writer writer;

    private Command state;

    public LoggerTypedController(Writer writer) {
        this.writer = writer;
    }

    public void log(Command command) {
        if (command.shouldAppend(state)) {
            state = command.append(state);
        } else {
            flush();
        }
        if(state == null) {
            state = command;
        }
    }

    public void flush() {
        if (state != null) {
            writer.write(state.getDecoratedMessage());
            state = null;
        }
    }
}