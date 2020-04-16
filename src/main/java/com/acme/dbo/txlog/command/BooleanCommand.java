package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

public class BooleanCommand implements Command {
    private String DECOR = "primitive: ";

    private boolean currentValue;
    private String accumulator;

    public BooleanCommand(boolean message) {
        currentValue = message;
        accumulator = convertBooleanToString(message);
    }

    @Override
    public Command accumulate(Controller controller, Command command) {
        if (command instanceof BooleanCommand) {
            BooleanCommand castedCommand = (BooleanCommand) command;
            if (castedCommand.accumulator == null) {
                this.accumulator = convertBooleanToString(this.currentValue);
            } else {
                this.accumulator = castedCommand.accumulator + System.lineSeparator() + getDecoratedCurrentValue();
            }
        }
        return this;
    }

    @Override
    public String getCurrentValue() {
        return convertBooleanToString(currentValue);
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
        return getDecoratedValue(convertBooleanToString(currentValue));
    }

    private String getDecoratedValue(String object) {
        return DECOR + object;
    }

    private String convertBooleanToString(boolean character) {
        return Boolean.toString(character);
    }

}
