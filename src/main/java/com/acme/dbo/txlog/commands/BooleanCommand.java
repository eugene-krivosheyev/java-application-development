package com.acme.dbo.txlog.commands;

public class BooleanCommand extends BaseCommand {
    public static final String BOOLEAN_DECORATION = "primitive: ";
    private boolean message;


    public BooleanCommand(boolean message) {
        this.message = message;
    }
    protected String getDecorator(){
        return BOOLEAN_DECORATION;
    }
    public String getMessage() {
        return String.valueOf(message);
    }
}
