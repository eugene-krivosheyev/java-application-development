package com.acme.dbo.txlog;

public class DecoratorByte implements Decorator {
    private static final String PREFIX_PRIMITIVE = "primitive: ";

    static void decorate(Object message) {
        System.out.println(PREFIX_PRIMITIVE +(byte)(message));
    }
}
