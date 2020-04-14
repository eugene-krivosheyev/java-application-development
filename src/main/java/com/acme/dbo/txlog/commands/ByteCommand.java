package com.acme.dbo.txlog.commands;

public class ByteCommand implements Command {

    private Byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public String getDecoratedMessage() {
        return null;
    }

    @Override
    public boolean isSame(Command command) {
        return false;
    }

    @Override
    public void accumulate(Command command) {

    }

    @Override
    public boolean validate(Command command) {
        return false;
    }


}
