package com.acme.dbo.txlog;



public class Facade {

    static OutputDecorator logger = new OutputDecorator(new ConsoleLogger());

    public static void log(int message) {
        logger.log(message);
    }

    public static void log(byte message) {
        logger.log(message);
    }

    public static void log(char message) {
        logger.log(message);
    }

    public static void log(boolean message) {
        logger.log(message);
    }

    public static void log(Object message) {
        logger.log(message);
    }

    public static void log(String message) {
        logger.log(message);
    }
}
