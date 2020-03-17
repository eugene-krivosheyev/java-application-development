package com.acme.dbo.txlog;


public class Facade {
    private static final String PREFIX_PRIMITIVE = "primitive";
    private static final String PREFIX_PREFERNCE = "reference";
    private static final String PREFIX_STRING = "string";
    private static final String PREFIX_CHAR = "char";

    public static void allog(String buildedString) {
        System.out.println(buildedString);
    }

    public static String stringBuilder(String message, String prefix) {
        return String.format("%s: %s", prefix, message);
    }

    public static void log(int message) {

        System.out.println(stringBuilder(String.valueOf(message), PREFIX_PRIMITIVE));

    }

    public static void log(byte message) {
        System.out.println(stringBuilder(Byte.toString(message), PREFIX_PRIMITIVE));
    }
    public static void log(String message) {
        System.out.println(stringBuilder(message, PREFIX_STRING));
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
