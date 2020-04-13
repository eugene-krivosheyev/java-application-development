package com.acme.dbo.txlog;

import static java.lang.Math.abs;

public class ByteCommand {
        private static String DECOR = "primitive: ";

        public Byte currentValue;
        private static String accumulator;
        private static Byte sum;
        private static Byte MAX_BYTE = Byte.MAX_VALUE;

        public ByteCommand(Byte message) {
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

        public static void flush() {
            accumulator = null;
            sum = 0;
        }

    private static boolean checkByteValueIsOutBound(Byte number) {
        short shortValue = (short) number;
        if (abs(shortValue) >= MAX_BYTE) {
            return true;
        } else return false;
    }
}
