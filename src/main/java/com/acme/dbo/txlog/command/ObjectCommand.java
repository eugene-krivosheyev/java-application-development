package com.acme.dbo.txlog.command;

public class ObjectCommand implements LogCommand {
    LogType type = LogType.OBJ;
    private Object message;

    public ObjectCommand(Object message) {
        this.message = message;
    }

    @Override
    public String getValue() {
        return message.toString();
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
