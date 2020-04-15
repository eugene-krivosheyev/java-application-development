package com.acme.dbo.txlog;

import static java.lang.Math.abs;

class ByteCommand {
    private String DECOR = "primitive: ";

    private Byte currentValue;
    private String accumulator;
    private Byte sum;
    private Byte MAX_BYTE = Byte.MAX_VALUE;

    ByteCommand(Byte message) {
        currentValue = message;
        accumulator = message.toString();
        sum = message;
    }

    String getDecoratedState() {
        return DECOR + accumulator;
    }

    ByteCommand accumulate(Controller controller, ByteCommand command) {
        if (command.accumulator == null) {
            accumulator = this.currentValue.toString();
            sum = this.currentValue;
        } else {
            if (checkByteValueIsOutBound(this.currentValue)) {
                controller.flush();
                accumulator = MAX_BYTE + "";
                sum = MAX_BYTE;
                controller.flush();
            } else {
                sum = (byte) (command.sum + this.currentValue);
                if (command.accumulator.contains(System.lineSeparator())) {
                    accumulator = command.accumulator + sum + System.lineSeparator();
                }
                accumulator = sum.toString();
            }
        }
        return this;
    }

    void flush() {
        accumulator = null;
        sum = 0;
    }

    private boolean checkByteValueIsOutBound(Byte number) {
        short shortValue = (short) number;
        return abs(shortValue) >= MAX_BYTE;
    }
}
