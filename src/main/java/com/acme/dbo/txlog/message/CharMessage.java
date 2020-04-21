package com.acme.dbo.txlog.message;

public class CharMessage extends MessageBase {

    private char value;

    public CharMessage(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }
}
