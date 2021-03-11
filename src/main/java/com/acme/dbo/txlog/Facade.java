package com.acme.dbo.txlog;

public class Facade {

    public static void log(Object message) {
        outputDecoratedMessage(decorateMessage(message));
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

    private static String decorateMessage(Object message) {
        return getPrefixByType(message) + message.toString();
    }

    private static void outputDecoratedMessage(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
