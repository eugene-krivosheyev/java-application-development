package com.acme.dbo.txlog;


public class Facade {
    private static final String PREFIX_PRIMITIVE = "primitive";
    private static final String PREFIX_PREFERNCE = "reference";
    private static final String PREFIX_STRING = "string";
    private static final String PREFIX_CHAR = "char";
    private static String msgType = "Blank";
    private static Integer intAccum;
    private static String stringAccum;


    public static String stringBuilder(String message, String prefix) {
        return String.format("%s: %s", prefix, message);
    }

    public static void flush() {
        if (stringAccum != null) {
            System.out.println(stringAccum);
            stringAccum = null;
        } else if (intAccum != null) {
            System.out.println(intAccum);
            intAccum = null;
        }

    }

    public static void log(int message) {
        if (intAccum != null) {
            intAccum = intAccum + message;
        } else {
            flush();
            intAccum = message;
        }
    }

    public static void log(String message) {
        flush();
        stringAccum = message;


    }

    public static void log(byte message) {
        System.out.println(stringBuilder(Byte.toString(message), PREFIX_PRIMITIVE));
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
