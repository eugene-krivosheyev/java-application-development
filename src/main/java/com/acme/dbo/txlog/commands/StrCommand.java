package com.acme.dbo.txlog.commands;

public class StrCommand implements Command {
    private String message;
    private static int counter = 1;

    public StrCommand(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String getDecoratedMessage() {
        String result = "string: " + getMessage() + (counter < 2 ? "" : " (x" + counter + ")");
        counter = 1;
        return result;
    }

    @Override
    public boolean isSame(Command command) {
        return command instanceof StrCommand && message.equals(((StrCommand)command).getMessage());
    }

    @Override
    public void accumulate(Command command) {
        ++counter;
    }

    @Override
    public boolean validate(Command command) {
        return true;
    }
}
