package com.acme.dbo.txlog;

public class Facade {

    public static void log(Object message) {
        outputMessageWithPrefix(getPrefixByType(message), message);
    }

    private static void outputMessageWithPrefix(String prefix, Object message) {
        System.out.println(prefix + ": " + message);
    }

    private static String getPrefixByType(Object message) {
        if ((message instanceof Integer) | (message instanceof Byte) | (message instanceof Boolean)) {
            return "primitive";
        } else if (message instanceof String){
            return "string";
        } else if (message instanceof Character) {
            return "char";
        } else {
            return "reference";
        }
    }
}
