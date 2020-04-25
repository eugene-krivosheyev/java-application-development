package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

import java.io.IOException;

import static java.lang.Math.abs;

abstract class BaseNumericCommand implements Command {
    private String DECOR = "primitive: ";

    protected Integer currentValue;
    protected String accumulator;
    protected Integer sum;

    protected Controller controller;
    private BaseNumericCommand commandToAccumulate;

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
    public BaseNumericCommand accumulate(Controller controller, Command command) throws IOException {
        if (command instanceof BaseNumericCommand) {
            commandToAccumulate = (BaseNumericCommand) command;
            this.controller = controller;
            if (commandToAccumulate.accumulator == null) {
                accumulateNewCommand();
            } else
                accumulateSameCommand();
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

    void actionIfOutOfBoundValue(Integer maxValue) throws IOException {
        controller.flush();
        accumulator = maxValue + "";
        sum = maxValue;
        controller.flush();
    }

    boolean checkNumValueIsOutBound(Integer number, Integer maxValue) {
        return abs(number.longValue()) >= maxValue;
    }

    private void accumulateNewCommand() {
        accumulator = this.currentValue.toString();
        sum = this.currentValue;
    }

    private void accumulateSameCommand() throws IOException {
        if (checkNumValueIsOutBound(this.currentValue, null)) {
            actionIfOutOfBoundValue(null);
        } else
            accumulator = Integer.toString(this.commandToAccumulate.sum + this.currentValue);
    }
}
