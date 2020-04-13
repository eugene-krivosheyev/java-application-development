package com.acme.dbo.txlog.commands;

public class ObjectCommand implements Command {
    public static final String OBJECT_DECORATION = "reference: ";
    private Object message;

    public ObjectCommand(Object message) {
        this.message = message;
    }

    public String getMessage() {
        return String.valueOf(message);
    }

    public String getDecoratedMessage() {
        return OBJECT_DECORATION + getMessage();
    }

    @Override
    public boolean shouldAppend(Command state) {
        return false;
    }

    public Command append(Command state) {
        return null;
    }

}
