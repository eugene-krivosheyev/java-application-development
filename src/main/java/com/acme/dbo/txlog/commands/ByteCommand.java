package com.acme.dbo.txlog.commands;

public class ByteCommand implements Command {
    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    public byte getMessage() {
        return message;
    }

    @Override
    public String getDecoratedMessage() {
        return "primitive: " + getMessage();
    }

    @Override
    public boolean isSame(Command command) {
        return command instanceof ByteCommand;
    }

    @Override
    public boolean validate(Command command) {
        return ! isOverflow(message, ((ByteCommand)command).getMessage());
    }

    @Override
    public void accumulate(Command command) {
        message += ((ByteCommand)command).getMessage();
    }

    private boolean isOverflow(byte a, byte b) {
        return  ((a > 0 && b > Byte.MAX_VALUE - a) || (a < 0 && b < Byte.MIN_VALUE - a));
    }
}
