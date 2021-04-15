package com.acme.dbo.txlog.message;

public interface Message {

    Object getValue();

    Message accumulate(Message message);

    @Override
    String toString();

    Message getDefaultMessage();

    default boolean isNumberOverflow(Message message) {
        return false;
    }

    default boolean isValueEqual(Message message) {
        return false;
    }
}
