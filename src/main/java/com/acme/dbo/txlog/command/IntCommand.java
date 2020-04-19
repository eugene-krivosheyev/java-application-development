package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

import static java.lang.Math.abs;

public class IntCommand implements Command {
    private String DECOR = "primitive: ";

    private Integer currentValue;
    private String accumulator;
    private Integer sum;
    private int MAX_INTEGER = Integer.MAX_VALUE;

    private Controller controller;

    public IntCommand(Integer message) {
        currentValue = message;
        accumulator = message.toString();
        sum = message;
    }

    @Override
    public String getDecoratedState(int duplicationNum) {
        return DECOR + accumulator;
    }

    @Override
    public Command accumulate(Controller controller, Command command) {
        if (command instanceof IntCommand) {
            IntCommand intCommand = (IntCommand) command;
            this.controller = controller;
            if (intCommand.accumulator == null) {
                accumulator = this.currentValue.toString();
                sum = this.currentValue;
            } else {
                if (checkIntegerValueIsOutBound(this.currentValue)) {
                    actionIfOutOfBoundValue();
                } else {
                    this.accumulator = Integer.toString(sum + this.currentValue);
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
        accumulator = MAX_INTEGER + "";
        sum = MAX_INTEGER;
        controller.flush();
    }

    private boolean checkIntegerValueIsOutBound(Integer number) {
        long longValue = (long) number;
        return abs(longValue) >= Integer.MAX_VALUE;
    }
}
