package com.acme.dbo.txlog.message;

public class PrefixMessage extends MessageBase {

    private String prefix;
    private MessageBase message;

    public PrefixMessage(String prefix, MessageBase message){
        this.prefix = prefix;
        this.message = message;
    }

    @Override
    public String toString() {
        return prefix + ": " + message.toString();
    }
}
