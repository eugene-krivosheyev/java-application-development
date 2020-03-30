package com.acme.dbo.txlog;


public class Facade {
    private static final String PREFIX_PRIMITIVE = "primitive";
    private static final String PREFIX_PREFERNCE = "reference";
    private static final String PREFIX_STRING = "string";
    private static final String PREFIX_CHAR = "char";
    private static String msgType = "Blank";
    private static Integer intAccum;
    private static Byte byteAccum;

    private static String stringAccum;


    public static String stringBuilder(String message, String prefix) {

        return String.format("%s: %s", prefix, message);
    }

    public static void flush() {
        if (stringAccum != null) {
            System.out.println(stringAccum);
            stringAccum = null;
        } else if (byteAccum != null) {
            System.out.println(byteAccum);
            byteAccum = null;
        } else if (intAccum != null) {
            System.out.println(intAccum);
            intAccum = null;
        }

    }

    public static void log(int message) {

        if ((intAccum != null) && checkNotOverMaxInt(message, intAccum)) {
            intAccum = intAccum + message;
        } else {
            flush();
            intAccum = message;
        }
    }

    private static boolean checkNotOverMaxInt(int a, int b) {
        return (a >= 0 && a + b >= b || a < 0 && a + b < b);
    }


    public static void log(String message) {
        flush();
        stringAccum = message;


    }

    public static void log(byte message) {
        if ((byteAccum != null) && (checkNotOverMaxByte(message, byteAccum))) {
            byteAccum = (byte) (byteAccum + message);
        } else {
            flush();
            byteAccum = message;
        }
    }


    private static boolean checkNotOverMaxByte(byte a, byte b) {
        return (a >= 0 && (byte) (a + b) >= b || a < 0 && (byte) (a + b) < b);
    }


    public static void log(boolean message) {
        System.out.println(stringBuilder(Boolean.toString(message), PREFIX_PRIMITIVE));
    }

    public static void log(char message) {
        System.out.println(stringBuilder(String.valueOf(message), PREFIX_CHAR));
    }

    public static void log(Object message) {
        System.out.println(stringBuilder(message.toString(), PREFIX_PREFERNCE));
    }

}
