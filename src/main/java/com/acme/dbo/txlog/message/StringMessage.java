package com.acme.dbo.txlog.message;


public class StringMessage implements Message{

    private final String DECORATION_PREFIX  = "string: ";
    private final String DECORATION_POSTFIX = "";

    private final Object value;
    private final int repeateCounter;

    public StringMessage(String value) {
        this(value, 1);
    }

    public StringMessage() {
        this("");
    }

    private StringMessage(String value, int repeateCounter) {
        this.value = value;
        this.repeateCounter = repeateCounter;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public StringMessage getDefaultMessage() {
        return new StringMessage();
    }

    public boolean isValueEqual(Message message) {
        return this.value.equals(message.getValue());
    }

    public StringMessage accumulate(Message message) {
        if (value.equals(message.getValue())) {
            return new StringMessage(value.toString(), repeateCounter + 1);
        } else {
            return new StringMessage(message.getValue().toString(), 1);
        }
    }
    @Override
    public String toString() {
        if (repeateCounter > 1) {
            return DECORATION_PREFIX + value + " (x" + repeateCounter + ")" + DECORATION_POSTFIX;
        } else {
            return DECORATION_PREFIX + value + DECORATION_POSTFIX;
        }
    }
}
