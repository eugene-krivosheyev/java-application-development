package com.acme.dbo.txlog;

public class OutputDecorator implements Logger{

    private Logger logger;

    OutputDecorator(Logger logger) {
       this.logger = logger;
    }

    public void log(byte message) {
        logger.log("primitive: " + message);
    }

    public void log(String message) {
        logger.log("string: " + message);
    }

    public void log(char message) {
        logger.log("char: " + message);
    }

    public void log(int message) {
        logger.log("primitive: " + message);
    }

    public void log(float message) {
        logger.log("primitive: " + message);
    }

    public void log(boolean message) {
        logger.log("primitive: " + message);
    }

    public void log(Object message) {
        logger.log("reference: " + message);
    }
}
