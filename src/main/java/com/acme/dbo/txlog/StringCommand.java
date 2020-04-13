package com.acme.dbo.txlog;

public class StringCommand {

    private static String DECOR = "string: ";

    public String currentValue;
    private static String accumulator;
    private static String lastString;

    public StringCommand(String message) {
        currentValue = message;
        if (accumulator == null) {
            accumulator = message;
        }
    }

    public void accumulate() {
        if (accumulator == null) {
            accumulator = this.currentValue;
        } else {
            accumulator = accumulator + System.lineSeparator() + getDecoratedValue(this.currentValue);
        }
    }


    public static String getDecoratedState() {
        return DECOR + accumulator;
    }

    public static String getDecoratedValue(String value) {
        return DECOR + value;
    }

    public static void flush() {
        accumulator = null;
    }
}
