package com.acme.dbo.txlog;

import javafx.util.Pair;

import java.util.Arrays;

import static java.lang.Math.abs;

public class Facade {
    public static void log(int message, boolean isDecorated) {
    Controller.log(message,  isDecorated);
    }

    public static void log(boolean message, boolean isDecorated) {
        Controller.log(message,  isDecorated);
    }

    public static void log(byte message, boolean isDecorated) {
        Controller.log(message,  isDecorated);
    }

    public static void log(char message, boolean isDecorated) {
        Controller.log(message,  isDecorated);
    }

    public static void log(String message, boolean isDecorated) {
        Controller.log(message,  isDecorated);
    }

    public static void log(boolean isDecorated, String... strings) {
        Controller.log(isDecorated,  strings);
    }

    public static void log(Object message, boolean isDecorated) {
        Controller.log(message,  isDecorated);
    }

    public static void log(int[] ints, boolean isDecorated) {
        Controller.log(ints,  isDecorated);
    }

    public static void log(int[][] ints, boolean isDecorated) {
        Controller.log(ints,  isDecorated);
    }

    public static void log(int[][][][] ints, boolean isDecorated) {
        Controller.log(ints,  isDecorated);
    }

    public static void flush(boolean isDecorated) {
        Controller.flush(isDecorated);
    }

}
