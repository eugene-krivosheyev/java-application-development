package com.acme.dbo.txlog.command;

import java.io.IOException;

public class IntCommand extends BaseNumericCommand {

    public IntCommand(Integer message) {
        super(message);
    }

    @Override
    protected void actionIfOutOfBoundValue(Integer maxValue) throws IOException {
        super.actionIfOutOfBoundValue(Integer.MAX_VALUE);
    }

    @Override
    protected boolean checkNumValueIsOutBound(Integer number, Integer maxValue) {
        return super.checkNumValueIsOutBound(number, Integer.MAX_VALUE);
    }
}
