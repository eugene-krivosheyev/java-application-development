package com.acme.dbo.txlog.message;

import static com.acme.dbo.txlog.message.utils.DecoratingUtils.matrixToString;

public class IntMatrixDecoratingMessage extends AbstractDecoratingMessage {
    private static final String PREFIX = "primitives matrix: ";

    public IntMatrixDecoratingMessage(final int[][] body) {
        this.body = matrixToString(body);
        this.prefix = PREFIX;
    }

    @Override
    public boolean isEqualType(DecoratingMessage message) {
        return message instanceof IntMatrixDecoratingMessage;
    }
}
