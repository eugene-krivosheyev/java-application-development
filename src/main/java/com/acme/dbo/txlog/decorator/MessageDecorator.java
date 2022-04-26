package com.acme.dbo.txlog.decorator;

public class MessageDecorator<T> {

    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String OBJECT_PREFIX = "reference: ";
    private static final String PRIMITIVE_PREFIX = "primitive: ";

    public static <T> String decorate (T message) {
        return getPrefix(message) + message;
    }

    private static <T> String getPrefix (T message) {
        if (message == null) {
            return "";
        }
        switch (message.getClass().getSimpleName()) {
            case "Character": return CHAR_PREFIX;
            case "String"   : return STRING_PREFIX;
            case "Object"   : return OBJECT_PREFIX;
            default         : return PRIMITIVE_PREFIX;
        }
    }
}
