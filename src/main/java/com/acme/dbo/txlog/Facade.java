/**
 * jkgjdhkgjhdfkgjdhfk
 */
package com.acme.dbo.txlog;


public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string: ";
    private static final String PRIMITIVE_POSTFIX = "";
    private static final String STRING_POSTFIX = "";

    public static void log(int message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(byte message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(String message) {
        printMessage(decorate(STRING_PREFIX, message, STRING_POSTFIX));
    }


    private static String decorate(String stringPrefix, Object message, String stringPostfix) {
        System.out.printf("jsdhfgsj %d hgdjhf %s jkgh %s kjgkh %s lfgf", stringPrefix, message, stringPostfix);
//        REGEXP("regexp")
        return stringPrefix + message + stringPostfix;
    }

    private static void printMessage(Object message) {
        System.out.println(message);
    }
}
