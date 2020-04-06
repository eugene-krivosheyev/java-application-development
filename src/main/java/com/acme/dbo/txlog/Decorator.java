package com.acme.dbo.txlog;

public class Decorator {

    public static String decorateMessage (Message message) {
        switch (message.getMessageType()) {
            case INT:
            case BYTE:
            case BOOLEAN:
                return MessagePrefix.PRIMITIVE.getMessagePrefix();
            case CHAR:
                return MessagePrefix.CHAR.getMessagePrefix();
            case PRIMITIVE_ARRAY:
                return MessagePrefix.PRIMITIVES_ARRAY.getMessagePrefix();
            case PRIMITIVE_MATRIX:
                return MessagePrefix.PRIMITIVES_MATRIX.getMessagePrefix();
            case OBJECT:
                return MessagePrefix.REFERENCE.getMessagePrefix();
            case STRING:
                return MessagePrefix.STRING.getMessagePrefix();
            case PRIMITIVE_MULTIMATRIX:
                return MessagePrefix.PRIMITIVES_MULTIMATRIX.getMessagePrefix();
            default:
                return null;
        }
    }
}
