package com.acme.dbo.txlog;

public class BooleanCommand extends TemplateCommand {
    private boolean message;

    public BooleanCommand(boolean message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "primitive: " + message;
    }
}
