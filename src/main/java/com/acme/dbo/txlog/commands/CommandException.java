package com.acme.dbo.txlog.commands;

public class CommandException extends Exception {
    public CommandException (String message ){
        super(message);
    }
}
