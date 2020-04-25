package com.acme.dbo.txlog.command;

public class CharCommand extends BaseAccumulatedCommand {
    private String DECOR = "char: ";

    public CharCommand(char message) {
        super(message);
    }

    @Override
    protected String getDecoratedValue(String object, String decor) {
        return super.getDecoratedValue(object, DECOR);
    }
}