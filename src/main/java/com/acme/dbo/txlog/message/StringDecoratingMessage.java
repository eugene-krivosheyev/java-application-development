package com.acme.dbo.txlog.message;

public class StringDecoratingMessage implements DecoratingMessage, AccumulatingMessage {
    private final String body;
    private final int repeated;

    public StringDecoratingMessage(final String body) {
        this.body = body;
        this.repeated = 1;
    }

    public StringDecoratingMessage(final String body, final int repeated) {
        this.body = body;
        this.repeated = repeated;
    }

    @Override
    public String getDecoratedMessage() {
        if (repeated > 1) {
            return String.format("string: %s (x%d)", this.body, this.repeated);
        }
        return "string: " + body;
    }

    @Override
    public AccumulatingMessage accumulate(AccumulatingMessage message) {
        if (!(message instanceof StringDecoratingMessage)) {
            throw new IllegalArgumentException("Parameter 'message' is not of type " + this.getClass().getTypeName());
        }
        final StringDecoratingMessage addingMessage = (StringDecoratingMessage) message;
        if (this.body != null && this.body.equals(addingMessage.getBody())) {
            return new StringDecoratingMessage(this.body, this.repeated + 1);
        }
        return addingMessage;
    }

    @Override
    public String getBody() {
        return body;
    }
}
