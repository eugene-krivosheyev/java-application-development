package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.decorators.Decorator;

public class StringCommand extends CountableCommand {
    public StringCommand(String message, Decorator decorator) {
        this.message = message;
        this.decorator = decorator;
    }
}
