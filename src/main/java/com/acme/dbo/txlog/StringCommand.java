package com.acme.dbo.txlog;

class StringCommand {

    private static String DECOR = "string: ";

    String currentValue;
    private static String accumulator;

    StringCommand(String message) {
        currentValue = message;
        if (accumulator == null) {
            accumulator = message;
        }
    }

    void accumulate() {
        if (accumulator == null) {
            accumulator = this.currentValue;
        } else {
            accumulator = accumulator + System.lineSeparator() + getDecoratedValue(this.currentValue);
        }
    }


    static String getDecoratedState() {
        return DECOR + accumulator;
    }

    private static String getDecoratedValue(String value) {
        return DECOR + value;
    }

    static void flush() {
        accumulator = null;
    }
}
