package com.acme.dbo.txlog;

public class Facade {

    public static void log(int message) {
        Controller.intCommand = new IntCommand(message);
        Controller.log(Controller.intCommand);
    }

    public static void log(byte message) {
        Controller.byteCommand = new ByteCommand(message);
        Controller.log(Controller.byteCommand);
    }

    public static void log(String message) {
        Controller.stringCommand = new StringCommand(message);
        Controller.log(Controller.stringCommand);
    }

    public static void log(boolean message) {
        Controller.logBoolean(message);
    }

    public static void log(char message) {
        Controller.logChar(message);
    }

    public static void log(String... strings) {
        Controller.log(strings);
    }

    public static void log(Object message) {
        Controller.log(message);
    }

    public static void log(int[] ints) {
        Controller.log(ints);
    }

    public static void log(int[][] ints) {
        Controller.log(ints);
    }

    public static void log(int[][][][] ints) {
        Controller.log(ints);
    }

    public static void flush() {
        Controller.flush();
    }

}
