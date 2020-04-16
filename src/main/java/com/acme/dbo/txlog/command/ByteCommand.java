package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

import static java.lang.Math.abs;

public class ByteCommand implements Command {
    private String DECOR = "primitive: ";

    private Byte currentValue;
    private String accumulator;
    private Byte sum;
    private Byte MAX_BYTE = Byte.MAX_VALUE;

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
        if(command instanceof ByteCommand) {
            ByteCommand byteCommand = (ByteCommand) command;
            if (byteCommand.accumulator == null) {
                accumulator = this.currentValue.toString();
                sum = this.currentValue;
            } else {
                if (checkByteValueIsOutBound(this.currentValue)) {
                    controller.flush();
                    accumulator = MAX_BYTE + "";
                    sum = MAX_BYTE;
                    controller.flush();
                } else {
                    accumulator = addCurrentValueAndSumToAccumulator(byteCommand.accumulator, byteCommand.sum, this.currentValue);
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

    private String addCurrentValueAndSumToAccumulator(String accumulator, Byte sum, Byte currentValue) {
        String totalAccumulator;
        int accumulatedSum = sum + currentValue;
        if (accumulator.contains(System.lineSeparator())) {
            totalAccumulator = accumulator + Integer.toString(accumulatedSum) + System.lineSeparator();
        } else {
            totalAccumulator = Integer.toString(accumulatedSum);
        }
        return totalAccumulator;
    }

    private boolean checkByteValueIsOutBound(Byte number) {
        short shortValue = (short) number;
        return abs(shortValue) >= MAX_BYTE;
    }
}
