package com.acme.dbo.txlog.command;


import com.acme.dbo.txlog.Controller;

public class BaseNumericCommand extends BaseCommand {
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
                if (checkNumValueIsOutBound(this.currentValue)) {
                    actionIfOutOfBoundValue();
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

    protected void actionIfOutOfBoundValue() {
    }

    protected boolean checkNumValueIsOutBound(Number number) {
        return true;
    }

}
