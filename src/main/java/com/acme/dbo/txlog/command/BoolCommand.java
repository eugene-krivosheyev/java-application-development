package com.acme.dbo.txlog.command;

public class BoolCommand implements LogCommand {
    boolean message;
    LogType type = LogType.BOOL;

    public BoolCommand(boolean message) {
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
}
