package com.acme.dbo.txlog.command;

public class ByteCommand {
    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.valueOf(message);
    }

    public boolean isCumulative(ByteCommand previousCommand) {
        return Byte.MAX_VALUE - this.message > previousCommand.message;
    }

    public ByteCommand accumulateWith(ByteCommand previousCommand) {
        return new ByteCommand((byte) (previousCommand.message + this.message));
    }
}
