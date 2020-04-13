package com.acme.dbo.txlog.commands;

public class StringCommand implements Command {
    public static final String STRING_DECORATION = "string: ";
    private String message;
    private int count;

    public StringCommand(String message) {
        this.message = message;
        count = 1;
    }

    private StringCommand(String message, int count) {
        this.message = message;
        this.count = count;
    }

    public String getMessage() {
        return message + (count > 1 ? (" (x" + count + ")") : "");
    }
    public String getDecoratedMessage() {
        return STRING_DECORATION + getMessage();
    }

    @Override
    public boolean shouldAppend(Command state) {
        if(state instanceof StringCommand) {
            StringCommand stringCommand = (StringCommand) state;
            return stringCommand.message.equals(message);
        }
        return false;
    }

    public Command append(Command state) {
        return new StringCommand(message, ((StringCommand) state).count + 1);
    }
}
