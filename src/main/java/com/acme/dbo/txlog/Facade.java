package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Decorator.decorate;

public class Facade {
    private static boolean intSequence;
    private static int intSum;

    private static boolean byteSequence;
    private static byte byteSum;

    private static int stringCounter;
    private static String lastString;

    private static Class<?> lastUsedType;

    public static void log(int message) {
        if (lastUsedType != Integer.class) {
            flush();
        }

        if ((long) intSum + message >= Integer.MAX_VALUE) {
            flush();
        }
        accumulate(message);
    }

    private static void accumulate(int message) {
        intSequence = true;
        intSum += message;
        lastUsedType = Integer.class;
    }

    public static void log(byte message) {
        if (lastUsedType != Byte.class) {
            flush();
        }

        if (byteSum + message >= Byte.MAX_VALUE) {
            flush();
        }
        accumulate(message);
    }

    private static void accumulate(byte message) {
        byteSequence = true;
        byteSum += message;
        lastUsedType = Byte.class;
    }

    public static void log(char message) {
        print(decorate(message));
    }

    public static void log(String message) {
        if (lastUsedType != String.class) {
            flush();
        }

        if (lastString == null || lastString.equals(message)) {
            lastString = message;
            accumulate();
        } else {
            flush();
            lastString = message;
            accumulate();
        }
    }

    private static void accumulate() {
        stringCounter++;
        lastUsedType = String.class;
    }

    public static void log(boolean message) {
        print(decorate(message));
    }

    public static void log(Object message) {
        print(decorate(message));
    }

    public static void flush() {
        if (intSequence) {
            print(decorate(intSum));
            intSequence = false;
            intSum = 0;
        }

        if (byteSequence) {
            print(decorate(byteSum));
            byteSequence = false;
            byteSum = 0;
        }

        if (lastString != null) {
            if (stringCounter > 0) {
                print(
                        decorate(lastString + (stringCounter > 1 ? String.format(" (x%s)", stringCounter) : ""))
                );
                stringCounter = 0;
                lastString = null;
            } else {
                print(decorate(lastString));
                lastString = null;
            }
        }
    }

    private static void print(Object message) {
        printToConsole(message);
    }

    private static void printToConsole(Object message) {
        System.out.println(message);
    }
}