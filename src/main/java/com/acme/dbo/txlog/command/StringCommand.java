package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

public class StringCommand implements Command {

    private String DECOR = "string: ";

    private String currentValue;
    private String accumulator;

    public StringCommand(String message) {
        currentValue = message;
        accumulator = message;
    }

    @Override
    public Command accumulate(Controller controller, Command command) {
        if (command instanceof StringCommand) {
            StringCommand stringCommand = (StringCommand) command;
            if (stringCommand.accumulator == null) {
                this.accumulator = this.currentValue;
            } else {
                this.accumulator = stringCommand.accumulator + System.lineSeparator() + getDecoratedCurrentValue();
            }
        }
        return this;
    }

    @Override
    public String getCurrentValue() {
        return currentValue;
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

    public void flush() {
        accumulator = null;
    }

    private String getDecoratedCurrentValue() {
        return getDecoratedValue(currentValue);
    }

    private String getDecoratedValue(String object) {
        return DECOR + object;
    }
}
