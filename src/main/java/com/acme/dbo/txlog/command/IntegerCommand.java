package com.acme.dbo.txlog.command;

public class IntegerCommand implements LogCommand, AccumulatedCommand {
    private int message;
    LogType type = LogType.INT;

    public IntegerCommand(int message) {
        this.message = message;
    }

    @Override
    public String getValue() {
        return String.valueOf(message);
    }

    @Override
    public LogType getType() {
        return type;
    }

    @Override
    public String getPrefix() {
        return type.getPrefix();
    }

    @Override
    public boolean isCumulative(LogCommand previousCommand) {
        if (!(previousCommand instanceof IntegerCommand)) return false;
        return Integer.MAX_VALUE - this.message > ((IntegerCommand) previousCommand).message;
    }

    @Override
    public LogCommand accumulateWith(LogCommand previousCommand) {
        return new IntegerCommand(((IntegerCommand) previousCommand).message + this.message);
    }
}
