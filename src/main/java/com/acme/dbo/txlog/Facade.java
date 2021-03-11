package com.acme.dbo.txlog;

import java.util.HashMap;

public class Facade {

    static HashMap<String,String>  PrefixMessage = new HashMap<String,String>();
    static {

        PrefixMessage.put("Primitive", "primitive: ");
        PrefixMessage.put("Char", "char: ");
        PrefixMessage.put("String", "string: ");
        PrefixMessage.put("Reference", "reference: ");
    }
    private static void printMessage(String Richmessage) {
        System.out.println(Richmessage);
    }

    public static void log(int message) {
        printMessage(PrefixMessage.get("Primitive") + message);
    }

    public static void log(byte message) {
        printMessage(PrefixMessage.get("Primitive") + message);
    }

    public static void log(char message) {
        printMessage(PrefixMessage.get("Char") + message);
    }

    public static void log(String message) {
        printMessage(PrefixMessage.get("String") + message);
    }
    public static void log(boolean message) {
        printMessage(PrefixMessage.get("Primitive") + message);
    }

    public static void log(Object message) {
        printMessage(PrefixMessage.get("Reference") + message);
    }
}
