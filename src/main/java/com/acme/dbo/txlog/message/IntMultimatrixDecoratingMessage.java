package com.acme.dbo.txlog.message;

import static com.acme.dbo.txlog.message.utils.DecoratingUtils.multiMatrixToString;

public class IntMultimatrixDecoratingMessage extends AbstractDecoratingMessage {
    private static final String PREFIX = "primitives multimatrix: ";

    public IntMultimatrixDecoratingMessage(final int[][][][] body) {
        this.body = body;
        this.prefix = PREFIX;
        this.decoratingFunction = (p) -> multiMatrixToString((int[][][][]) p);
    }

    @Override
    public boolean isEqualType(DecoratingMessage message) {
        return message instanceof IntMultimatrixDecoratingMessage;
    }
}
