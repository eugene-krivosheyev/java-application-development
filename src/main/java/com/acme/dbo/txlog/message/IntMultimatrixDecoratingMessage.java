package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.message.utils.DecoratingUtils;

public class IntMultimatrixDecoratingMessage extends AbstractDecoratingMessage<int[][][][]> {
    private static final String PREFIX = "primitives multimatrix: ";

    public IntMultimatrixDecoratingMessage(final int[][][][] body) {
        this.body = body;
        this.prefix = PREFIX;
        this.decoratingFunction = DecoratingUtils::multiMatrixToString;
    }

    @Override
    public boolean isEqualType(DecoratingMessage message) {
        return message instanceof IntMultimatrixDecoratingMessage;
    }
}
