package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

import static java.lang.Math.abs;

public class ByteCommand implements Command {
    private String DECOR = "primitive: ";

    private Byte currentValue;
    private String accumulator;
    private Byte sum;
    private Byte MAX_BYTE = Byte.MAX_VALUE;

    private Controller controller;

    public ByteCommand(Byte message) {
        currentValue = message;
        accumulator = message.toString();
        sum = message;
    }

    @Override
    public String getDecoratedState(int duplicationNum) {
        return DECOR + accumulator;
    }

    @Override
    public ByteCommand accumulate(Controller controller, Command command) {
        if (command instanceof ByteCommand) {
            ByteCommand byteCommand = (ByteCommand) command;
            this.controller = controller;
            if (byteCommand.accumulator == null) {
                accumulator = this.currentValue.toString();
                sum = this.currentValue;
            } else {
                if (checkByteValueIsOutBound(this.currentValue)) {
                    actionIfOutOfBoundValue();
                } else {
                    accumulator = Integer.toString(sum + this.currentValue);
                }
            }
        }
        return this;
    }

    @Override
    public String getCurrentValue() {
        return currentValue.toString();
    }

    @Override
    public void flush() {
        accumulator = null;
        sum = 0;
    }

    private void actionIfOutOfBoundValue() {
        controller.flush();
        accumulator = MAX_BYTE + "";
        sum = MAX_BYTE;
        controller.flush();
    }

    private boolean checkByteValueIsOutBound(Byte number) {
        short shortValue = (short) number;
        return abs(shortValue) >= MAX_BYTE;
    }
}
