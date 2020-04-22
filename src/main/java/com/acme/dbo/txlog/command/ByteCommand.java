package com.acme.dbo.txlog.command;

import static java.lang.Math.abs;

public class ByteCommand extends BaseNumericCommand {

    public ByteCommand(Byte message) {
        super((int) message);
    }

    @Override
    protected void actionIfOutOfBoundValue() {
        controller.flush();
        accumulator = Byte.MAX_VALUE + "";
        sum = (int) Byte.MAX_VALUE;
        controller.flush();
    }

    @Override
    protected boolean checkNumValueIsOutBound(Number number) {
        return abs(number.shortValue()) >= Byte.MAX_VALUE;
    }
}
