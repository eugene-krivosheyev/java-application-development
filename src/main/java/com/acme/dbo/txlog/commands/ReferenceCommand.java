package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.decorators.Decorator;

public class ReferenceCommand extends CountableCommand {
    public ReferenceCommand(Object message, Decorator decorator) {
        this.message = message;
        this.decorator = decorator;
    }
}
