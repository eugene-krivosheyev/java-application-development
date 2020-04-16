package com.acme.dbo.txlog;

public class CharCommand extends RepeatableCommand {
    public CharCommand(char message) {
        this.message = message;
        this.decorator = new PrefixDecorator("char");
    }
}
