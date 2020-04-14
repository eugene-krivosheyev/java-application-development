package com.acme.dbo.txlog;

public class StringCommand extends RepeatableCommand {
    public StringCommand(String message) {
        super();
        this.message = message;
        this.decorator = new PrefixDecorator("string");
    }
}
