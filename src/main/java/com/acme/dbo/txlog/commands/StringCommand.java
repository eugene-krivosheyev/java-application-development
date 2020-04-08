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

    public Command append(Command commandState) {
        if(commandState instanceof StringCommand) {
            StringCommand stringCommand = (StringCommand) commandState;
            if (stringCommand.message.equals(message)) {
                return new StringCommand(message, stringCommand.count + 1);
            }
        }
        return null;
    }
}
