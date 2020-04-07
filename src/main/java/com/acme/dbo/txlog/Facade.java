package com.acme.dbo.txlog;

import com.acme.dbo.txlog.command.*;

public class Facade {
    private static LogController controller = new LogController();

    public static void log(int message) {
        controller.log(new IntegerCommand(message));
    }

    public static void log(char message) {
        controller.log(new CharCommand(message));
    }

    public static void log(String message) {
        controller.log(new StringCommand(message));
    }

    public static void log(boolean message) {
        controller.log(new BoolCommand(message));
    }

    public static void log(Object message) {
        controller.log(new ObjectCommand(message));
    }

    public static void log(byte message) {
        controller.log(new ByteCommand(message));
    }

    public static void log(int[][] message) {
        controller.log(new MatrixCommand(message));
    }

    public static void log(int[][][][] message) {
        controller.log(new MultiMatrixCommand(message));
    }

    public static void log(int... message) {
        for (int i : message) log(i);
    }

    public static void log(String... message) {
        for (String i : message) log(i);
    }

    public static void stop() {
        controller.stop();
    }
}
