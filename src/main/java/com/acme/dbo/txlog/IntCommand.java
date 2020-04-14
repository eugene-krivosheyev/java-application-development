package com.acme.dbo.txlog;

public class IntCommand extends NumberCommand {
    public IntCommand(int message) {
        super(message);
    }

    @Override
    public Command accumulate(Command command) throws Exception {
        long sum = (long) message + (long) ((IntCommand) command).message;
        if (sum > Integer.MAX_VALUE) {
            throw new Exception("Overflow");
        }
        return new IntCommand((int) sum);
    }
}
