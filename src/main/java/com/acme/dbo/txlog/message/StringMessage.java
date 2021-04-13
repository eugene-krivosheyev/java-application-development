package com.acme.dbo.txlog.message;


public class StringMessage {

    private final String DECORATION_PREFIX  = "string: ";
    private final String DECORATION_POSTFIX = "";

    private final String value;
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

    public String getValue() {
        return value;
    }

    public boolean isValueEqual(StringMessage message) {
        return this.value.equals(message.getValue());
    }

    public StringMessage accumulate(StringMessage message) {
        if (value.equals(message.getValue())) {
            return new StringMessage(value, repeateCounter + 1);
        } else {
            return new StringMessage(message.getValue(), 1);
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
