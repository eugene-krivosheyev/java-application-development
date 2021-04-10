package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.utils.Utils;

public class IntMultimatrixDecoratingMessage implements DecoratingMessage {
    public static final String PREFIX = "primitives multimatrix: ";
    private final int[][][][] body;

    public IntMultimatrixDecoratingMessage(final int[][][][] body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return PREFIX + Utils.multiMatrixToString(this.body);
    }

    @Override
    public int[][][][] getBody() {
        return this.body;
    }
}
