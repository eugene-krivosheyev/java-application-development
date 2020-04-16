package com.acme.dbo.txlog;

import static java.lang.Math.abs;

class IntCommand implements Command {
    private String DECOR = "primitive: ";

    private Integer currentValue;
    private String accumulator;
    private Integer sum;
    private int MAX_INTEGER = Integer.MAX_VALUE;

    IntCommand(Integer message) {
        currentValue = message;
        accumulator = message.toString();
        sum = message;
    }

    String getDecoratedState() {
        return DECOR + accumulator;
    }

    @Override
    public IntCommand accumulate(Controller controller, Command command) {
        if(command instanceof IntCommand) {
            IntCommand intCommand = (IntCommand) command;
            if (intCommand.accumulator == null) {
                accumulator = this.currentValue.toString();
                sum = this.currentValue;
            } else {
                if (checkIntegerValueIsOutBound(this.currentValue)) {
                    controller.flush();
                    accumulator = MAX_INTEGER + "";
                    sum = MAX_INTEGER;
                    controller.flush();
                } else {
                    accumulator = addCurrentValueAndSumToAccumulator(intCommand.accumulator, intCommand.sum, this.currentValue);
                }
            }
        }
        return this;
    }

    private String addCurrentValueAndSumToAccumulator(String accumulator, Integer sum, Integer currentValue) {
        String totalAccumulator;
        int accumulatedSum = sum + currentValue;
        if (accumulator.contains(System.lineSeparator())) {
            totalAccumulator = accumulator + Integer.toString(accumulatedSum) + System.lineSeparator();
        } else {
            totalAccumulator = Integer.toString(accumulatedSum);
        }
        return totalAccumulator;
    }

    void flush() {
        accumulator = null;
        sum = 0;
    }

    private boolean checkIntegerValueIsOutBound(Integer number) {
        long longValue = (long) number;
        return abs(longValue) >= Integer.MAX_VALUE;
    }
}
