package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Facade.PRIMITIVE;
import static com.acme.dbo.txlog.Facade.TYPEINT;

public class IntCommand implements Command {
    private int message;
    private byte messageType;


    public IntCommand(int message)    {
        this.message = message;
        this.messageType = TYPEINT;
    }

    public byte getMessageType () {
        return this.messageType;
    }

    public String getMessage() {
        return Integer.toString(this.message);
    }

    @Override
    public String decoratedMessage() {
        return (PRIMITIVE + Integer.toString(this.message));
    }

    @Override
    public Command accumulateCommand(Command command) {
        this.message = this.message+ Integer.parseInt(command.getMessage());
        return this;
    }

    public boolean isSame(Command command) {
        return this.messageType == command.getMessageType();
    }

    public boolean checkOverflow(Command command) {
        int commandMessage = Integer.parseInt(command.getMessage());
        if ((this.message > 0 && commandMessage > 0) || (this.message < 0 && commandMessage < 0)) {
            return (Integer.MAX_VALUE - Math.abs(this.message) >= Math.abs(commandMessage));
        } else {
            return true;
        }
    }
}
