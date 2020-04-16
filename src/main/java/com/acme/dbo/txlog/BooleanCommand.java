package com.acme.dbo.txlog;

public class BooleanCommand extends RepeatableCommand {
    public BooleanCommand(boolean message) {
        this.message = message;
        this.decorator = new PrefixDecorator("primitive");
    }
}
