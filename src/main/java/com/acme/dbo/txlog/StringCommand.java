package com.acme.dbo.txlog;

public class StringCommand extends RepeatableCommand {
    public StringCommand(String message) {
        this.message = message;
        this.decorator = new PrefixDecorator("string");
    }
}
