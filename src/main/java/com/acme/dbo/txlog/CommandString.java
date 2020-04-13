package com.acme.dbo.txlog;

public class CommandString implements Command {
    private final String message;
    private static final String PREFIX_STRING = "string: ";
    private int stringCounter;

    public CommandString(String message) {
        this.message = message;
        this.stringCounter = 1;
    }

    public CommandString(String message, int stringCounter) {
        this.message = message;
        this.stringCounter = stringCounter;
    }

    @Override
    public Boolean isSame(Command currentState) {
        return currentState instanceof CommandString;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public Command updateState(Command currentState) {
        return new CommandString(this.message, ((CommandString) currentState).stringCounter + 1);
    }

    @Override
    public Boolean updateNeeded(Command currentState) {
        return this.message.equals(((CommandString) currentState).getMessage());
    }

    @Override
    public String decorate(Command command) {
        String message = this.message + (stringCounter > 1 ? (" (x" + stringCounter + ")") : "");
        stringCounter = 1;
        return PREFIX_STRING + message;

    }
}
