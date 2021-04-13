package com.acme.dbo.txlog.message;

public class StringMessage implements Message {
    private final String STRING_PREFIX = "string: ";
    private final String STRING_POSTFIX = "";

    private int stringCounter = 1;
    private final String message;

    public StringMessage(String message) {
        this.message = message;
    }

    @Override
    public String getDecoratedMessage() {
        return STRING_PREFIX + getStringDependingOnCounter() + STRING_POSTFIX;
    }

    public String getStringDependingOnCounter() {
        if (stringCounter == 1) {
            return message;
        } else {
            return message + " (x" + stringCounter + ")";
        }
    }

    @Override
    public boolean equalType(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public StringMessage accumulate(Message intMessage) {
        if (!(intMessage instanceof IntMessage)) throw new IllegalArgumentException("Message");
        StringMessage newMessage = (IntMessage) intMessage;
        return new IntMessage(this.getMessage() + newMessage.getMessage());
    }

    public String getMessage() {
        return message;
    }

    public void incrementCounter() {
        stringCounter++;
    }

    public boolean messageEquals(StringMessage stringMessage) {
        return this.getMessage().equals(stringMessage.getMessage());
    }
}
