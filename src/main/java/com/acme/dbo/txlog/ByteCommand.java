package com.acme.dbo.txlog;

public class ByteCommand extends NumberCommand {
    public ByteCommand(byte message) {
        super(message);
    }

    @Override
    public Command accumulate(Command command) throws Exception {
        long sum = (long) message + (long) ((ByteCommand) command).message;
        if (sum > Byte.MAX_VALUE) {
            throw new Exception("Overflow");
        }
        return new ByteCommand((byte) sum);
    }
}
