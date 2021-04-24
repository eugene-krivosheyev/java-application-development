package com.acme.dbo.txlog.message;

public class IntDecoratingMessage extends AbstractDecoratingMessage<Long> {
    private static final String PREFIX = "primitive: ";
    private final int overflowMaxValue;

    public IntDecoratingMessage(final long body) {
        this.body = body;
        this.overflowMaxValue = Integer.MAX_VALUE;
        this.prefix = PREFIX;
    }

    @Override
    public boolean isEqualType(final DecoratingMessage message) {
        return message instanceof IntDecoratingMessage;
    }

    @Override
    public DecoratingMessage accumulate(final DecoratingMessage message) {
        if (!(message instanceof IntDecoratingMessage)) {
            throw new IllegalArgumentException("Parameter 'message' is not of type " + this.getClass().getTypeName());
        }
        final IntDecoratingMessage addingMessage = (IntDecoratingMessage) message;
        if (this.body + addingMessage.body > this.overflowMaxValue) {
            return message;
        }
        return new IntDecoratingMessage(this.body + addingMessage.body);
    }
}
