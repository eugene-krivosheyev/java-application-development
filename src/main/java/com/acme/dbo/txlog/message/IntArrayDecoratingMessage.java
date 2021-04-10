package com.acme.dbo.txlog.message;

import static com.acme.dbo.txlog.utils.Utils.arrayToString;

public class IntArrayDecoratingMessage implements DecoratingMessage {
    public static final String PREFIX = "primitives array: ";
    private final int[] body;

    public IntArrayDecoratingMessage(final int[] body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return PREFIX + arrayToString(this.body);
    }

    @Override
    public int[] getBody() {
        return this.body;
    }
}
