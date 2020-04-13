package com.acme.dbo.txlog;

import static java.lang.Math.abs;

public class IntCommand {
    private static String DECOR = "primitive: ";

    public Integer currentValue;
    private static String accumulator;
    private static Integer sum;
    private static int MAX_INTEGER = Integer.MAX_VALUE;

    public IntCommand(Integer message) {
        currentValue = message;
        if (accumulator == null) {
            accumulator = message.toString();
            sum = message;
        }
    }

    public static String getDecoratedState() {
        return DECOR + accumulator;
    }

    public void accumulate() {
        if (accumulator == null) {
            accumulator = this.currentValue.toString();
            sum = this.currentValue;
        } else {
            if (checkIntegerValueIsOutBound(this.currentValue)) {
                Controller.flush();
                accumulator = MAX_INTEGER + "";
                sum = MAX_INTEGER;
                Controller.flush();
            } else {
                sum = sum + this.currentValue;
                if (accumulator.contains(System.lineSeparator())) {
                    accumulator = accumulator + sum + System.lineSeparator();
                } else {
                    accumulator = sum.toString();
                }
            }
        }
    }

    public static void flush() {
        accumulator = null;
        sum = 0;
    }

    private static boolean checkIntegerValueIsOutBound(Integer number) {
        long longValue = (long) number;
        if (abs(longValue) >= Integer.MAX_VALUE) {
            return true;
        } else return false;
    }
}
