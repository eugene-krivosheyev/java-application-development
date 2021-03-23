package com.acme.dbo.txlog;

import static java.lang.System.*;

public class Facade {

    public static final String PRIMITIVE_PREFIX = "";
    public static final String CHAR_PREFIX = "";
    public static final String STRING_PREFIX = "";
    public static final String REFERENCE_PREFIX = "";
    public static final String PRIMITIVE_POSTFIX = "";
    public static final String REFERENCE_POSTFIX = "";
    public static final String STRING_POSTFIX = "";
    public static final String CHAR_POSTFIX = "";

    private static String stringAccum = "";
    private static int intAccum = 0;

    public static void log(int message) {
        intAccum = intAccum + message;
    }

    public static void log(byte message) {
        printMessage(decorate(PRIMITIVE_PREFIX,message, PRIMITIVE_POSTFIX));
    }

    public static void log(char message) {
        printMessage(decorate(CHAR_PREFIX,message, CHAR_POSTFIX));
    }

    public static void log(String message) {
        printMessage(decorate(STRING_PREFIX,message, STRING_POSTFIX));
    }

    public static void log(boolean message) {
        printMessage(decorate(PRIMITIVE_PREFIX,message, PRIMITIVE_POSTFIX));
    }

    public static void log(Object message) {
        printMessage(decorate(REFERENCE_PREFIX,message, REFERENCE_POSTFIX));
    }

    private static String decorate(String prefix,Object message,String postfix) {
        return prefix + message + postfix;
    }

    private static void printMessage(String message) {
        stringAccum = stringAccum + message + "\n";
    }

    public static void flush( ) {
        printMessage(decorate(REFERENCE_PREFIX,intAccum, REFERENCE_POSTFIX));
        out.print(stringAccum);
        stringAccum = "";
        intAccum = 0;
    }


}
