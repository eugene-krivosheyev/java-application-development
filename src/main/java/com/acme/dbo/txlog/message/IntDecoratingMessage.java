package com.acme.dbo.txlog.message;

public class IntDecoratingMessage extends NumberDecoratingMessage {
    public IntDecoratingMessage(final long body) {
        super(body);
        this.maxValue = Integer.MAX_VALUE;
    }
}
