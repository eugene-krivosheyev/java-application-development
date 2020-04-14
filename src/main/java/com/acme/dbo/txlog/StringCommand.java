package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Facade.STRING;
import static com.acme.dbo.txlog.Facade.TYPESTRING;

public class StringCommand implements Command {
    private String message;
    private byte messageType;
    private int stringCounter;


    public StringCommand(String message)    {
        this.message = message;
        this.messageType = TYPESTRING;
        this.stringCounter = 1;
    }

    public byte getMessageType () {
        return this.messageType;
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
        return (this.messageType == command.getMessageType() && this.message.equals(command.getMessage()));
    }

    public boolean checkOverflow(Command command) {
        return true;
    }
}


