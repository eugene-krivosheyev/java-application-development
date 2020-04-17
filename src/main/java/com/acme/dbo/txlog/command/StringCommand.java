package com.acme.dbo.txlog.command;

import static com.acme.dbo.txlog.Facade.STRING;

public class StringCommand extends CheckingCommand {
    private String message;
    private int stringCounter;


    public StringCommand(String message)    {
        this.message = message;
        this.stringCounter = 1;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPrefix() {
        return STRING;
    }

    public String getStringMessage () {
        return this.message;
    }

    public String getAdditionalDecoration () {
        if (stringCounter > 1) {
            return " (x" + stringCounter + ")";
        } else {
            return "";
        }
    }

    @Override
    public void accumulateCommand(Command command) {
        this.stringCounter++;
    }

    public boolean checkIsSame(Command command) {
        return this.message.equals(((StringCommand)command).getMessage());
    }
}


