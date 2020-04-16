package com.acme.dbo.txlog.command;

public class CharCommand implements LogCommand {
    private char message;
    LogType type = LogType.CHAR;

    public CharCommand(char message) {
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
