package com.acme.dbo.txlog.command;

public class IntegerCommand {
    private int message;

    public IntegerCommand(int message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.valueOf(message);
    }

    public boolean isCumulative(IntegerCommand previousCommand) {
        return Integer.MAX_VALUE - this.message > previousCommand.message;
    }

    public IntegerCommand accumulateWith(IntegerCommand previousCommand) {
        return new IntegerCommand(previousCommand.message + this.message);
    }
}
