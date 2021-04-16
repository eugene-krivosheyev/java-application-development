package com.acme.dbo.txlog.message;

public class StringDecoratingMessage extends AbstractDecoratingMessage {
    private static final String PREFIX = "string: ";
    private final String body;
    private final int repeated;

    public StringDecoratingMessage(final String body) {
        this.body = body;
        this.repeated = 1;
        this.prefix = PREFIX;
    }

    public StringDecoratingMessage(final String body, final int repeated) {
        this.body = body;
        this.repeated = repeated;
    }

    @Override
    public String getDecoratedMessage() {
        if (this.repeated > 1) {
            return String.format("string: %s (x%d)", this.body, this.repeated);
        }
        return this.prefix + this.body;
    }

    @Override
    public boolean isEqualType(DecoratingMessage message) {
        return message instanceof StringDecoratingMessage;
    }

    @Override
    public DecoratingMessage accumulate(DecoratingMessage message) {
        if (!(message instanceof StringDecoratingMessage)) {
            throw new IllegalArgumentException("Parameter 'message' is not of type " + this.getClass().getTypeName());
        }
        final StringDecoratingMessage addingMessage = (StringDecoratingMessage) message;
        if (this.body != null && this.body.equals(addingMessage.body)) {
            return new StringDecoratingMessage(this.body, this.repeated + 1);
        }
        return addingMessage;
    }
}
