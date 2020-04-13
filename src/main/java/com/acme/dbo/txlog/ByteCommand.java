package com.acme.dbo.txlog;

import static java.lang.Math.abs;

class ByteCommand {
    private static String DECOR = "primitive: ";

    private Byte currentValue;
    private static String accumulator;
    private static Byte sum;
    private static Byte MAX_BYTE = Byte.MAX_VALUE;

    ByteCommand(Byte message) {
        currentValue = message;
        if (accumulator == null) {
            accumulator = message.toString();
            sum = message;
        }
    }

    static String getDecoratedState() {
        return DECOR + accumulator;
    }

    void accumulate() {
        if (accumulator == null) {
            accumulator = this.currentValue.toString();
            sum = this.currentValue;
        } else {
            if (checkByteValueIsOutBound((byte) (this.currentValue))) {
                Controller.flush();
                accumulator = MAX_BYTE + "";
                sum = MAX_BYTE;
                Controller.flush();
            } else {
                sum = (byte) (sum + this.currentValue);
                if (accumulator.contains(System.lineSeparator())) {
                    accumulator = accumulator + sum + System.lineSeparator();
                }
                accumulator = sum.toString();
            }
        }
    }

    static void flush() {
        accumulator = null;
        sum = 0;
    }

    private static boolean checkByteValueIsOutBound(Byte number) {
        short shortValue = (short) number;
        return abs(shortValue) >= MAX_BYTE;
    }
}
