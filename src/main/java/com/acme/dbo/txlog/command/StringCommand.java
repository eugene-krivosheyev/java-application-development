package com.acme.dbo.txlog.command;

public class StringCommand implements LogCommand, AccumulatedCommand {
    private String message;
    LogType type = LogType.STR;
    int count;

    public StringCommand(String message) {
        this.message = message;
        count = 1;
    }

    private StringCommand(String message, int count) {
        this(message);
        this.count = count;
    }

    @Override
    public String getValue() {
        if (count > 1) return message + " (x" + count + ")";
        return message;
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
        if (!(previousCommand instanceof StringCommand)) return false;
        return message.equals(((StringCommand) previousCommand).message);
    }

    @Override
    public LogCommand accumulateWith(LogCommand previousCommand) {
        return new StringCommand(message, count + ((StringCommand) previousCommand).count);
    }
}
