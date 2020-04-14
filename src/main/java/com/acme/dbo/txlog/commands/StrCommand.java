package com.acme.dbo.txlog.commands;

public class StrCommand implements Command {

    private String message = "";
    private static String accumulator = "";
    private static int counter = 0;

    public StrCommand(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getDecoratedMessage() {
        return "string:" + getMessage();
    }

    public boolean isSame(Command command) {
        return false;
    }

    @Override
    public void accumulate(Command command) {

    }

    @Override
    public boolean validate(Command command) {
        return false;
    }

}
