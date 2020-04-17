package com.acme.dbo.txlog.command;

import static com.acme.dbo.txlog.Facade.PRIMITIVE;

public class ByteCommand extends CheckingCommand {
    private byte message;


    public ByteCommand(byte message)    {
        this.message = message;
    }

    public Byte getMessage() {
        return this.message;
    }

    @Override
    public void accumulateCommand(Command command) {
        this.message = (byte) (this.message+ (((ByteCommand)command).getMessage()));
    }

    public boolean checkNoOverflow(Command command) {
        byte commandMessage = ((ByteCommand)command).getMessage();
        if ((this.message > 0 && commandMessage > 0) || (this.message < 0 && commandMessage < 0)) {
            return (Byte.MAX_VALUE - Math.abs(this.message) >= Math.abs(commandMessage));
        } else {
            return true;
        }
    }

    public String getPrefix() {
        return PRIMITIVE;
    }

    public String getStringMessage () {
        return Byte.toString(this.message);
    }
}
