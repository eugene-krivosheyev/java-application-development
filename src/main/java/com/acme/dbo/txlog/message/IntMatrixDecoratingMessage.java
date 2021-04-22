package com.acme.dbo.txlog.message;

import static com.acme.dbo.txlog.message.utils.DecoratingUtils.matrixToString;

public class IntMatrixDecoratingMessage extends AbstractDecoratingMessage<int[][]> {
    private static final String PREFIX = "primitives matrix: ";

    public IntMatrixDecoratingMessage(final int[][] body) {
        this.body = body;
        this.prefix = PREFIX;
        this.decoratingFunction = (p) -> matrixToString((int[][]) p);
    }

    @Override
    public boolean isEqualType(DecoratingMessage message) {
        return message instanceof IntMatrixDecoratingMessage;
    }
}
