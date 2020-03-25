package com.acme.dbo.txlog;

public class Facade {
    private static Byte byteAccumulator;
    private static Integer intAccumulator;
    private static String stringAccumulator;
    private static int stringCounter;

    public static void flush() {
        if (stringAccumulator != null) {
            String message = stringAccumulator + (stringCounter > 1 ? (" (x" + stringCounter + ")") : "");
            logPrint("string: " + message);
            stringAccumulator = null;
        } else if (byteAccumulator != null) {
            logPrint("primitive: " + (byte) byteAccumulator);
            byteAccumulator = null;
        } else if (intAccumulator != null) {
            logPrint("primitive: " + (int) intAccumulator);
            intAccumulator = null;
        }
    }

    public static void log(int message) {
        if (intAccumulator != null && checkOverflow(message + intAccumulator, message, intAccumulator)) {
            intAccumulator += message;
        } else {
            flush();
            intAccumulator = message;
        }
    }


    public static void log(byte message) {
        if (byteAccumulator != null && checkOverflow((byte) (message + byteAccumulator), message, byteAccumulator)) {
            byteAccumulator = (byte)(message+byteAccumulator);
        } else {
            flush();
            byteAccumulator = message;
        }
    }


    public static void log(String message) {
        if (stringAccumulator == null || !stringAccumulator.equals(message)) {
            flush();
            stringAccumulator = message;
            stringCounter = 1;
        } else {
            stringCounter++;
        }
    }

    public static void log(Object o) {
        flush();
        logPrint("reference: " + o.toString());
    }

    public static void log(boolean message) {
        flush();
        logPrint("primitive: " + message);
    }

    public static void log(char message) {
        flush();
        logPrint("char: " + message);
    }

    private static void logPrint(String msg) {
        System.out.println(msg);
    }

    private static boolean checkOverflow(int sum, int a, int b) {
        return (a > 0 && sum > b || a < 0 && sum < b);
    }
}