package com.acme.dbo.txlog;

public class Facade {
    private static Controller controller = new Controller();

    public static void log(int message) {
        controller.log(new IntCommand(message));
    }

    public static void log(byte message) {
        controller.log(new ByteCommand(message));
    }

    public static void log(String message) {
        controller.log(new StringCommand(message));
    }

    public static void log(boolean message) {
        controller.logBoolean(message);
    }

    public static void log(char message) {
        controller.logChar(message);
    }

    public static void log(String... strings) {
        controller.log(strings);
    }

    public static void log(Integer... strings) {
        controller.log(strings);
    }

    public static void log(Object message) {
        controller.log(message);
    }

    public static void log(int[] ints) {
        controller.log(ints);
    }

    public static void log(int[][] ints) {
        controller.log(ints);
    }

    public static void log(int[][][][] ints) {
        controller.log(ints);
    }

    public static void flush() {
        controller.flush();
    }

}
