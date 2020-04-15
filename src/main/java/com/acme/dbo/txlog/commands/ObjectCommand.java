package com.acme.dbo.txlog.commands;

public class ObjectCommand extends BaseCommand {
    public static final String OBJECT_DECORATION = "reference: ";
    private Object message;

    public ObjectCommand(Object message) {
        this.message = message;
    }

    protected String getDecorator(){
        return OBJECT_DECORATION;
    }

    public String getMessage() {
        return String.valueOf(message);
    }
}
