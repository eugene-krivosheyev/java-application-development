package com.acme.dbo.txlog.command;

public class CharCommand {
    private char message;

    public CharCommand(char message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.valueOf(message);
    }
}
