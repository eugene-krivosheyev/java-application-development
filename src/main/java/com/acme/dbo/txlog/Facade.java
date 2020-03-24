package com.acme.dbo.txlog;

import static java.lang.Math.abs;

public class Facade {
    private static Integer integerAccumulator;
    private static Byte byteAccumulator;
    private static String stringAccumulator;
    private static String PRIMITIVE_DECOR = "primitive: ";
    private static String INTEGER_DECOR = PRIMITIVE_DECOR;
    private static String BYTE_DECOR = PRIMITIVE_DECOR;
    private static String CHAR_DECOR = "char: ";
    private static String STRING_DECOR = "string: ";
    private static String REFERENCE_DECOR = "reference: ";


    public static void log(int message, boolean isDecorated) {
        flushLastState(Facade.integerAccumulator, isDecorated, "Byte", "String");

        if (Facade.checkIntegerValueIsOutBound(message)) {
            flushLastState(Facade.integerAccumulator, isDecorated, "Integer");
            integerAccumulator = Integer.MAX_VALUE;
            flushLastState(Facade.integerAccumulator, isDecorated, "Integer");
        } else {
            if (integerAccumulator == null) {
                integerAccumulator = message;
            } else {
                integerAccumulator = integerAccumulator + message;
            }

        }
    }

    public static void log(boolean message, boolean isDecorated) {
        flushLastState(Facade.integerAccumulator, isDecorated, "Integer", "Byte", "String");

        String msg = String.valueOf(message);
        Facade.writeFormattedLog(Facade.PRIMITIVE_DECOR, msg, isDecorated);

    }

    public static void log(byte message, boolean isDecorated) {
        flushLastState(Facade.integerAccumulator, isDecorated, "Integer", "String");

        if (Facade.checkByteValueIsOutBound(message)) {
            flushLastState(Facade.integerAccumulator, isDecorated, "Byte");
            byteAccumulator = Byte.MAX_VALUE;
            flushLastState(Facade.integerAccumulator, isDecorated, "Byte");
        } else {
            String msg = String.valueOf(message);
            Facade.writeFormattedLog(Facade.BYTE_DECOR, msg, isDecorated);
        }

    }

    public static void log(char message, boolean isDecorated) {
        flushLastState(Facade.integerAccumulator, isDecorated, "Integer", "Byte", "String");

        String msg = String.valueOf(message);
        Facade.writeFormattedLog(CHAR_DECOR, msg, isDecorated);

    }

    public static void log(String message, boolean isDecorated) {
        flushLastState(Facade.integerAccumulator, isDecorated, "Integer", "Byte");

        if (stringAccumulator == null) {
            stringAccumulator = message + System.lineSeparator();
            stringAccumulator = message;
        } else {
            stringAccumulator = stringAccumulator + message + System.lineSeparator();
            stringAccumulator = stringAccumulator + message;
        }
    }


    public static void log(Object message, boolean isDecorated) {
        flushLastState(Facade.integerAccumulator, isDecorated, "Integer", "Byte", "String");

        System.out.println(REFERENCE_DECOR + message);
    }

    public static void flush(boolean isDecorated) {
        flushLastState(Facade.integerAccumulator, isDecorated, "Integer", "Byte", "String");
    }

    private static void writeFormattedLog(String decoration, Object message, boolean isDecorated) {
        if (isDecorated) {
            Facade.writeOutput(decoration + message);
        } else {
            Facade.writeOutput(message);
        }
    }

    private static void writeOutput(Object msg) {
        System.out.println(msg);
    }

    public static void flushLastState(Object accumulator, boolean isDecorated, String... types) {
        for (String current : types) {
            if (current.equals("Integer")) {
                flushLastIntegerState(isDecorated);
            }
            if (current.equals("Byte")) {
                flushLastByteState(isDecorated);
            }
            if (current.equals("String")) {
                flushLastStringState(isDecorated);
            }
        }
    }

    private static void flushLastIntegerState(boolean isDecorated) {
        if (integerAccumulator != null) {
            Facade.writeFormattedLog(INTEGER_DECOR, Facade.integerAccumulator, isDecorated);
        }
        integerAccumulator = null;
    }

    private static void flushLastByteState(boolean isDecorated) {
        if (byteAccumulator != null) {
            Facade.writeFormattedLog(BYTE_DECOR, Facade.byteAccumulator, isDecorated);
        }
        byteAccumulator = null;
    }

    private static void flushLastStringState(boolean isDecorated) {
        if (stringAccumulator != null) {
            Facade.writeFormattedLog(STRING_DECOR, Facade.stringAccumulator, isDecorated);
        }
        stringAccumulator = null;
    }

    private static boolean checkIntegerValueIsOutBound(Integer number) {
        long longValue = (long) number;
        if (abs(longValue) >= Integer.MAX_VALUE) {
            return true;
        } else return false;
    }

    private static boolean checkByteValueIsOutBound(Byte number) {
        short shortValue = (short) number;
        if (abs(shortValue) >= Byte.MAX_VALUE) {
            return true;
        } else return false;
    }
}
