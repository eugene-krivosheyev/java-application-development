package com.acme.dbo.txlog;

public class ByteCommand extends TemplateCommand {

    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public boolean isDataOverloaded(Command command) {
        if (isSame(command)) {
            return ((int)message + ((ByteCommand) command).message >= Byte.MAX_VALUE) || ((int)message + ((ByteCommand) command).message <= Byte.MIN_VALUE);
        }
        return true;
    }

    @Override
    public ByteCommand accumulate(Command command) {
        byte byteAccum = message;
        if (isSame(command) && !isDataOverloaded(command)) {
                byteAccum += ((ByteCommand) command).message;
        }
        return new ByteCommand(byteAccum);
    }

    @Override
    public String toString() {
        return "primitive: " + message;
    }

    @Override
    public boolean isNotAccumulatable() {
        return false;
    }
}
