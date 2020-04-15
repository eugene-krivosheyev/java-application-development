package com.acme.dbo.txlog;

public class ObjectCommand extends TemplateCommand {
    private Object message;

    public ObjectCommand(Object message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "reference: " + message;
    }
}
