package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Message;

import java.util.Objects;

public class StringMessage implements Message {
    private final String message;
    private int acc = 1;

    public StringMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StringMessage that = (StringMessage) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public void accumulate(Message message) {
        acc++;
    }

    @Override
    public String getDecoratedMessage() {
        return "string: " + message +
                (acc > 1 ? " (x" + acc + ")" : "");
    }
}
