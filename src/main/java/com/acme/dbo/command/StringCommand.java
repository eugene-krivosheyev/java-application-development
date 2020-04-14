package com.acme.dbo.command;

import static com.acme.dbo.txlog.Facade.STRING;

public class StringCommand implements Command {
    private String message;
    private int stringCounter;


    public StringCommand(String message)    {
        this.message = message;
        this.stringCounter = 1;
    }


    public String getMessage() {
        return this.message;
    }

    @Override
    public String decoratedMessage() {
        if (stringCounter > 1) {
            return (STRING + this.message + " (x" + stringCounter + ")");
        }   else {
            return STRING + this.message;
        }
    }

    @Override
    public Command accumulateCommand(Command command) {
        this.stringCounter++;
        return this;
    }

    public boolean isSame(Command command) {
        return (command instanceof StringCommand && this.message.equals(((StringCommand)command).getMessage()));
    }

    public boolean checkOverflow(Command command) {
        return true;
    }
}


