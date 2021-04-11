package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.message.utils.DecoratingUtils;

public class IntMatrixDecoratingMessage implements DecoratingMessage {
    public static final String PREFIX = "primitives matrix: ";
    private final int[][] body;

    public IntMatrixDecoratingMessage(final int[][] body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return PREFIX + DecoratingUtils.matrixToString(this.body);
    }

    @Override
    public int[][] getBody() {
        return this.body;
    }
}
