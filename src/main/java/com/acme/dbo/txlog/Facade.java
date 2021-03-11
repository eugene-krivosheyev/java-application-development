package com.acme.dbo.txlog;

public class Facade {

    public static void log(Object obj) {
        printMessage(decorate(obj));
    }

    private static String decorate(Object message) {
        String prefix = "reference: "; // default one, if need custom case - modify below

        if ((message instanceof Integer) || (message instanceof Byte) || (message instanceof Boolean)) {
            prefix = "primitive: ";
        } else if (message instanceof String ) {
            prefix = "string: ";
        } else if (message instanceof Character) {
            prefix = "char: ";
        }

        return prefix + message;
    }

    private static void printMessage(String msg) {
        System.out.println(msg);
    }
}
