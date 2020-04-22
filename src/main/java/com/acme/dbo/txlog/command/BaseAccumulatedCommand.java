package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

abstract class BaseAccumulatedCommand extends BaseCommand {
    protected Object currentValue;
    protected String accumulator;

    protected BaseAccumulatedCommand(Object message) {
        currentValue = message;
        accumulator = convertObjectToString(message);
    }

    @Override
    public Command accumulate(Controller controller, Command command) {
        if (command instanceof BaseAccumulatedCommand) {
            BaseAccumulatedCommand castedCommand = (BaseAccumulatedCommand) command;
            if (castedCommand.accumulator == null) {
                this.accumulator = convertObjectToString(this.currentValue);
            } else {
                this.accumulator = castedCommand.accumulator + System.lineSeparator() + getDecoratedCurrentValue();
            }
        }
        return this;
    }

    @Override
    public String getCurrentValue() {
        return convertObjectToString(currentValue);
    }

    @Override
    public String getDecoratedState(int duplicationNum) {
        String decoratedAccumulator;
        if (duplicationNum >= 1) {
            decoratedAccumulator = getDecoratedValue(accumulator) + " (x" + (duplicationNum + 1) + ")";
        } else {
            decoratedAccumulator = getDecoratedValue(accumulator);
        }
        return decoratedAccumulator;
    }

    private String getDecoratedCurrentValue() {
        return getDecoratedValue(convertObjectToString(currentValue));
    }

    public void flush() {
        accumulator = null;
    }


    private String convertObjectToString(Object character) {
        return String.valueOf(character);
    }

    protected abstract String getDecoratedValue(String object);

}
