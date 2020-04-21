package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.decorators.Decorator;

public class CharCommand extends CountableCommand {
    public CharCommand(char message, Decorator decorator) {
        this.message = message;
        this.decorator = decorator;
    }
}
