package com.acme.dbo.txlog.message;

import java.util.function.Function;

public abstract class AbstractDecoratingMessage implements DecoratingMessage {
    protected String prefix;
    protected Object body;
    protected Function<Object, String> decoratingFunction;

    @Override
    public DecoratingMessage accumulate(DecoratingMessage message) {
        return message;
    }

    @Override
    public String getDecoratedMessage() {
        if (decoratingFunction != null) {
            return prefix + decoratingFunction.apply(this.body);
        }
        return prefix + body;
    }
}
