package com.acme.dbo.txlog.message;

import static com.acme.dbo.txlog.message.utils.DecoratingUtils.arrayToString;

public class IntArrayDecoratingMessage extends AbstractDecoratingMessage {
    private static final String PREFIX = "primitives array: ";

    public IntArrayDecoratingMessage(final int[] body) {
        this.body = arrayToString(body);
        this.prefix = PREFIX;
    }

    @Override
    public boolean isEqualType(DecoratingMessage message) {
        return message instanceof IntArrayDecoratingMessage;
    }
}
