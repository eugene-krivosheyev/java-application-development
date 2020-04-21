package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

public class CharCommand extends BaseCommand {
    private String DECOR = "char: ";

    private char currentValue;
    private String accumulator;
    private Integer sum;

    public CharCommand(char message) {
        currentValue = message;
        accumulator = convertCharToString(message);
    }

    @Override
    public Command accumulate(Controller controller, Command command) {
        if (command instanceof CharCommand) {
            CharCommand stringCommand = (CharCommand) command;
            if (stringCommand.accumulator == null) {
                this.accumulator = convertCharToString(this.currentValue);
            } else {
                this.accumulator = stringCommand.accumulator + System.lineSeparator() + getDecoratedCurrentValue();
            }
        }
        return this;
    }

    @Override
    public String getCurrentValue() {
        return convertCharToString(currentValue);
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

    @Override
    public void flush() {
        accumulator = null;
    }

    private String getDecoratedCurrentValue() {
        return getDecoratedValue(convertCharToString(currentValue));
    }

    private String getDecoratedValue(String object) {
        return DECOR + object;
    }

    private String convertCharToString(char character) {
        return Character.toString(character);
    }
}
