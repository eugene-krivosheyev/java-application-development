package com.acme.dbo.txlog;

public class DecoratorString implements Decorator {
    private static final String PREFIX_STRING = "string: ";
    public static void decorate(Object message) {
        System.out.println(PREFIX_STRING+message.toString());
    }


}
