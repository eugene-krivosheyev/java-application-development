package com.acme.dbo.txlog;

public class Facade {

    public static void flush() {
        Logger.flush();
    }

    public static void log(int... message) {
        Logger.logOtherTypeMessage(new Message(message));
    }

    public static void log(int message) {
        Logger.logIntMessage(new Message(message));
    }

    public static void log(int[][] message) {
        Logger.logOtherTypeMessage(new Message(message));
    }

    public static void log(int[][][][] message) {
        Logger.logOtherTypeMessage(new Message(message));
    }

    public static void log(byte message) {
        Logger.logByteMessage(new Message(message));
    }

    public static void log(char message) {
        Logger.logOtherTypeMessage(new Message(message));
    }

    public static void log(String... message) {
        Logger.logStringArrayMessage(message);
    }

    public static void log(String message) {
        Logger.logStringMessage(new Message(message));
    }

    public static void log(boolean message) {
        Logger.logOtherTypeMessage(new Message(message));
    }

    public static void log(Object message) {
        Logger.logOtherTypeMessage(new Message(message));
    }
}
