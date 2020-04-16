package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

public class ObjectCommand implements Command {
    private String DECOR = "reference: ";

    private Object currentValue;
    private String accumulator;

    public ObjectCommand(Object message) {
        currentValue = message;
        accumulator = convertObjectToString(message);
    }

    @Override
    public Command accumulate(Controller controller, Command command) {
        if (command instanceof ObjectCommand) {
            ObjectCommand castedCommand = (ObjectCommand) command;
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

    public void flush() {
        accumulator = null;
    }

    private String getDecoratedCurrentValue() {
        return getDecoratedValue(convertObjectToString(currentValue));
    }

    private String getDecoratedValue(String object) {
        return DECOR + object;
    }

    private String convertObjectToString(Object character) {
        return character.toString();
    }

}
