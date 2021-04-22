package com.acme.dbo.txlog.message;

import static com.acme.dbo.txlog.message.utils.DecoratingUtils.arrayToString;

public class IntArrayDecoratingMessage extends AbstractDecoratingMessage<int[]> {
    private static final String PREFIX = "primitives array: ";

    public IntArrayDecoratingMessage(final int[] body) {
        this.body = body;
        this.prefix = PREFIX;
        this.decoratingFunction = (p) -> arrayToString((int[]) p);
    }

    @Override
    public boolean isEqualType(DecoratingMessage message) {
        return message instanceof IntArrayDecoratingMessage;
    }
}
