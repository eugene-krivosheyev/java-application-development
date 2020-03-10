package com.acme.dbo.txlog;

import java.io.PrintStream;

public class Facade {
    private static void print(String message, PrintStream os) {
        if (os == null) {
            System.out.println(message);
        } else {
            os.println(message);
        }
    }

    private static String decorate(Object message) {
        if (message instanceof Integer) {
            return "primitive: " + message.toString();
        } else if (message instanceof Character) {
            return "char: " + message.toString();
        } else if (message instanceof String) {
            return "string: " + message.toString();
        } else if (message instanceof Boolean) {
            return "primitive: " + message.toString();
        } else if (message instanceof Byte) {
            return "primitive: " + message.toString();
        } else
            return "reference: " + message.toString();
    }

    public static void log(Object message, PrintStream os) {
        print(decorate(message), os);
    }

    public static void log(Object message) {
        print(decorate(message), null);
    }

}
