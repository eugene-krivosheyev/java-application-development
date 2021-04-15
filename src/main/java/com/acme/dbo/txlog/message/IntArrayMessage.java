package com.acme.dbo.txlog.message;

public class IntArrayMessage implements Message{
    private final int[] value;
    private final String DECORATION_PREFIX  = "primitives array: ";
    private final String DECORATION_POSTFIX = "";
    private static final String ARRAY_PREFIX = "{";
    private static final String ARRAY_DEVIDER = ", ";
    private static final String ARRAY_POSTFIX = "}";


    public IntArrayMessage(int[] value) {
        this.value = value;
    }

    public IntArrayMessage() {
        this(new int[] {0});
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public IntArrayMessage accumulate(Message message) {
        return new IntArrayMessage((int[]) message.getValue());
    }

    @Override
    public String toString() {
        return DECORATION_PREFIX + arrayToString(value) + DECORATION_POSTFIX;
    }

    @Override
    public IntArrayMessage getDefaultMessage() {
        return new IntArrayMessage();
    }

    public String toString(boolean decorate) {
        if (decorate) {
            return toString();
        } else {
            return arrayToString(value);
        }
    }

    private String arrayToString(int[] intArray) {
        StringBuilder buffer = new StringBuilder(ARRAY_PREFIX);
        for (int element: intArray) {
            if (!buffer.toString().equals(ARRAY_PREFIX)) {
                buffer.append(ARRAY_DEVIDER).append(element);
            } else {
                buffer.append(element);
            }
        }
        return buffer.append(ARRAY_POSTFIX).toString();
    }
}
