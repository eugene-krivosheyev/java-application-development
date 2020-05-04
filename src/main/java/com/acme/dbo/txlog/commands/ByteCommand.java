package com.acme.dbo.txlog.commands;

public class ByteCommand extends NumCommand<Byte> {

    public ByteCommand(Byte message) {
        super(message);
    }

    @Override
    public boolean isSame(Command command) {
        return command instanceof ByteCommand;
    }

    @Override
    public boolean validate(Command command) {
        return ! isOverflow(message, ((ByteCommand)command).getMessage(), Byte.MAX_VALUE, Byte.MIN_VALUE);
    }

    @Override
    public void accumulate(Command command) {
        message = (byte)(message + ((ByteCommand) command).getMessage());
    }

}
