package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.decorators.Decorator;

public class BooleanCommand extends CountableCommand {
    public BooleanCommand(boolean message, Decorator decorator) {
        this.message = message;
        this.decorator = decorator;
    }
}
