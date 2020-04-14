package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Facade.PRIMITIVE;
import static com.acme.dbo.txlog.Facade.TYPEBYTE;

public class ByteCommand implements Command {
    private byte message;
    private byte messageType;


    public ByteCommand(byte message)    {
        this.message = message;
        this.messageType = TYPEBYTE;
    }

    public byte getMessageType () {
        return this.messageType;
    }

    public String getMessage() {
        return Byte.toString(this.message);
    }

    @Override
    public String decoratedMessage() {
        return (PRIMITIVE + Byte.toString(this.message));
    }

    @Override
    public Command accumulateCommand(Command command) {
        this.message = (byte) (this.message+ Byte.parseByte(command.getMessage()));
        return this;
    }

    public boolean isSame(Command command) {
        return this.messageType == command.getMessageType();
    }

    public boolean checkOverflow(Command command) {
        int commandMessage = Byte.parseByte(command.getMessage());
        if ((this.message > 0 && commandMessage > 0) || (this.message < 0 && commandMessage < 0)) {
            return (Byte.MAX_VALUE - Math.abs(this.message) >= Math.abs(commandMessage));
        } else {
            return true;
        }
    }
}
