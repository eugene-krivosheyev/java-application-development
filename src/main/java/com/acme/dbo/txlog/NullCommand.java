package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Facade.TYPENOTDEFINED;

public class NullCommand implements Command {
    private String message;
    private byte messageType = TYPENOTDEFINED;

    public NullCommand()    {
        this.message = null;
    }

    @Override
    public byte getMessageType () {
        return this.messageType;
    }

    public String getMessage() {
        return null;
    }

    @Override
    public String decoratedMessage() {
        return null;
    }

    @Override
    public Command accumulateCommand(Command command) {
        return null;
    }

    @Override
    public boolean isSame(Command command) {
        return false;
    }

    public boolean checkOverflow(Command command) {
        return false;
    }
}
