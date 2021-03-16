package com.acme.dbo.txlog;

public class Decorator {

    static String decorate(int message) {
        return decorateWithPrimitive(message);
    }

    static String decorate(byte message) {
        return decorateWithPrimitive(message);
    }

    static String decorate(char message) {
        return decorateWithChar(message);
    }

    static String decorate(String message) {
        return decorateWithString(message);
    }

    static String decorate(boolean message) {
        return decorateWithPrimitive(message);
    }

    static String decorate(Object message) {
        return decorateWithReference(message);
    }

    private static String decorateWithReference(Object message) {
        return "reference: " + message;
    }

    private static String decorateWithPrimitive(Object message) {
        return "primitive: " + message;
    }

    private static String decorateWithChar(char message) {
        return "char: " + message;
    }

    private static String decorateWithString(String message) {
        return "string: " + message;
    }
}