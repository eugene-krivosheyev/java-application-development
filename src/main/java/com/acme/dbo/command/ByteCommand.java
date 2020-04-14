package com.acme.dbo.command;

import static com.acme.dbo.txlog.Facade.PRIMITIVE;

public class ByteCommand implements Command {
    private byte message;


    public ByteCommand(byte message)    {
        this.message = message;
    }

    public Byte getMessage() {
        return this.message;
    }

    @Override
    public String decoratedMessage() {
        return (PRIMITIVE + Byte.toString(this.message));
    }

    @Override
    public Command accumulateCommand(Command command) {
        this.message = (byte) (this.message+ (((ByteCommand)command).getMessage()));
        return this;
    }

    public boolean isSame(Command command) {
        return command instanceof ByteCommand;
    }

    public boolean checkOverflow(Command command) {
        byte commandMessage = ((ByteCommand)command).getMessage();
        if ((this.message > 0 && commandMessage > 0) || (this.message < 0 && commandMessage < 0)) {
            return (Byte.MAX_VALUE - Math.abs(this.message) >= Math.abs(commandMessage));
        } else {
            return true;
        }
    }
}
