package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

import static java.lang.Math.abs;

abstract class BaseNumericCommand implements Command {
    private String DECOR = "primitive: ";

    protected Integer currentValue;
    protected String accumulator;
    protected Integer sum;

    protected Controller controller;

    protected BaseNumericCommand(Integer message) {
        currentValue = message;
        accumulator = message.toString();
        sum = message;
    }

    @Override
    public String getDecoratedState(int duplicationNum) {
        return DECOR + accumulator;
    }

    @Override
    public BaseNumericCommand accumulate(Controller controller, Command command) {
        if (command instanceof BaseNumericCommand) {
            BaseNumericCommand baseCommand = (BaseNumericCommand) command;
            this.controller = controller;
            if (baseCommand.accumulator == null) {
                accumulator = this.currentValue.toString();
                sum = this.currentValue;
            } else {
                if (checkNumValueIsOutBound(this.currentValue, null)) {
                    actionIfOutOfBoundValue(null);
                } else {
                    accumulator = Integer.toString(baseCommand.sum + this.currentValue);
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

    void actionIfOutOfBoundValue(Integer maxValue) {
        controller.flush();
        accumulator = maxValue + "";
        sum = maxValue;
        controller.flush();
    }

    boolean checkNumValueIsOutBound(Integer number, Integer maxValue) {
        return abs(number.longValue()) >= maxValue;
    }

}
