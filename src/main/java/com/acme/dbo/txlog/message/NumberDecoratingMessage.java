package com.acme.dbo.txlog.message;

public class NumberDecoratingMessage extends AbstractDecoratingMessage {
    private static final String PREFIX = "primitive: ";
    private final int overflowMaxValue;
    protected Long body;

    public NumberDecoratingMessage(final long body, final int overflowMaxValue) {
        this.body = body;
        this.overflowMaxValue = overflowMaxValue;
        this.prefix = PREFIX;
    }

    @Override
    public boolean isEqualType(DecoratingMessage message) {
        return message instanceof NumberDecoratingMessage
                && this.overflowMaxValue == ((NumberDecoratingMessage) message).overflowMaxValue;
    }

    @Override
    public String getDecoratedMessage() {
        return this.prefix + this.body;
    }

    @Override
    public DecoratingMessage accumulate(final DecoratingMessage message) {
        if (!(message instanceof NumberDecoratingMessage)) {
            throw new IllegalArgumentException("Parameter 'message' is not of type " + this.getClass().getTypeName());
        }
        final NumberDecoratingMessage addingMessage = (NumberDecoratingMessage) message;
        if (this.body + addingMessage.body > this.overflowMaxValue) {
            return message;
        }
        return new NumberDecoratingMessage(this.body + addingMessage.body, this.overflowMaxValue);
    }
}
