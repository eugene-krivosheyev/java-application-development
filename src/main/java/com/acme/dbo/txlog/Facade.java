package com.acme.dbo.txlog;

public class Facade {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String OBJECT_PREFIX = "reference: ";

    public static void log(Object obj) {
        printMessage(decorate(obj));
    }

    private static String decorate(Object message) {
        String prefix = OBJECT_PREFIX;

        if (message instanceof Integer) {
            prefix = PRIMITIVE_PREFIX;
        } else if (message instanceof Byte) {
            prefix = PRIMITIVE_PREFIX;
        } else if (message instanceof String ) {
            prefix = STRING_PREFIX;
        } else if (message instanceof Boolean) {
            prefix = PRIMITIVE_PREFIX;
        } else if (message instanceof Character) {
            prefix = CHAR_PREFIX;
        }

        return prefix + message;
    }

    private static void printMessage(String msg) {
        System.out.println(msg);
    }
}
