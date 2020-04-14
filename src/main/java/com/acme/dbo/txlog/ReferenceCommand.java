package com.acme.dbo.txlog;

public class ReferenceCommand extends RepeatableCommand {
    public ReferenceCommand(Object message) {
        super();
        this.message = message;
        this.decorator = new PrefixDecorator("reference");
    }
}
