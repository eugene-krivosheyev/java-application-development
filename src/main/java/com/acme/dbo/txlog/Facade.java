package com.acme.dbo.txlog;

import javafx.util.Pair;

import java.util.Arrays;

import static java.lang.Math.abs;

public class Facade {
    private static Boolean isDecorated=true;

    public static void log(int message) {
    Controller.logInteger(message,  isDecorated);
    }

    public static void log(boolean message) { Controller.logBoolean(message,  isDecorated); }

    public static void log(byte message) {
        Controller.logByte(message,  isDecorated);
    }

    public static void log(char message) {
        Controller.logChar(message,  isDecorated);
    }

    public static void log(String message) {
        Controller.log(message,  isDecorated);
    }

    public static void log(String... strings) {
        Controller.log(isDecorated,  strings);
    }

    public static void log(Object message) {
        Controller.log(message,  isDecorated);
    }

    public static void log(int[] ints) {
        Controller.log(ints,  isDecorated);
    }

    public static void log(int[][] ints) {
        Controller.log(ints,  isDecorated);
    }

    public static void log(int[][][][] ints) {
        Controller.log(ints,  isDecorated);
    }

    public static void flush() {
        Controller.flush(isDecorated);
    }

}
