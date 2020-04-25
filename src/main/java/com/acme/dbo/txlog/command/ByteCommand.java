package com.acme.dbo.txlog.command;

public class ByteCommand extends BaseNumericCommand {

    public ByteCommand(Byte message) {
        super((int) message);
    }

    @Override
    protected void actionIfOutOfBoundValue(Integer maxValue) {
        super.actionIfOutOfBoundValue((int) Byte.MAX_VALUE);
    }

    @Override
    protected boolean checkNumValueIsOutBound(Integer number, Integer maxValue) {
        return super.checkNumValueIsOutBound(number, (int) Byte.MAX_VALUE);
    }
}
