package com.acme.dbo.txlog.command;

public class ByteCommand implements LogCommand, AccumulatedCommand {
    private byte message;
    LogType type = LogType.BYTE;

    public ByteCommand(byte message) {
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
        if (!(previousCommand instanceof ByteCommand)) return false;
        return Byte.MAX_VALUE - this.message > ((ByteCommand) previousCommand).message;
    }

    @Override
    public LogCommand accumulateWith(LogCommand previousCommand) {
        return new ByteCommand((byte) (((ByteCommand) previousCommand).message + this.message));
    }
}
