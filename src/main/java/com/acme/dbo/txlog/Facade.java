package com.acme.dbo.txlog;

public class Facade {

    private static LogController logController = new LogController();

    public static void flush() {
        logController.flush();
    }

    public static void log(int... message) {
        logController.log(new IntArrayCommand(message));
    }

    public static void log(int message) {
        logController.log(new IntCommand(message));
    }

    public static void log(int[][] message) {
        logController.log(new IntMatrixCommand(message));
    }

    public static void log(int[][][][] message) {
        logController.log(new IntMultiMatrixCommand(message));
    }

    public static void log(byte message) {
        logController.log(new ByteCommand(message));
    }

    public static void log(char message) {
        logController.log(new CharCommand(message));
    }

    public static void log(String... message) {
        for (String str : message) {
            logController.log(new StringCommand(str));
        }
        logController.flush();
    }

    public static void log(String message) {
        logController.log(new StringCommand(message));
    }

    public static void log(boolean message) {
        logController.log(new BooleanCommand(message));
    }

    public static void log(Object message) {
        logController.log(new ObjectCommand(message));
    }
}
