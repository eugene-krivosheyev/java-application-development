package com.acme.dbo.txlog;

class StringCommand {

    private String DECOR = "string: ";

    String currentValue;
    private String accumulator;

    StringCommand(String message) {
        currentValue = message;
        accumulator = message;
    }

    StringCommand accumulate(Controller controller, StringCommand command) {
        if (command.accumulator == null) {
            this.accumulator = this.currentValue;
        } else {
            this.accumulator = command.accumulator + System.lineSeparator() + getDecoratedValue(this.currentValue);
        }
        return this;
    }

    String getDecoratedState() {
        return DECOR + accumulator;
    }

    private String getDecoratedValue(String value) {
        return DECOR + value;
    }

    void flush() {
        accumulator = null;
    }
}
