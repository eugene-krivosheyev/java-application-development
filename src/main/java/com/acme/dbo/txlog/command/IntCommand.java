package com.acme.dbo.txlog.command;

import static java.lang.Math.abs;

public class IntCommand extends BaseNumericCommand {

    public IntCommand(Integer message) {
        super(message);
    }

    @Override
    protected void actionIfOutOfBoundValue() {
        controller.flush();
        accumulator = Integer.MAX_VALUE + "";
        sum = Integer.MAX_VALUE;
        controller.flush();
    }

    @Override
    protected boolean checkNumValueIsOutBound(Number number) {
        long longValue = number.longValue();
        return abs(longValue) >= Integer.MAX_VALUE;
    }
}
