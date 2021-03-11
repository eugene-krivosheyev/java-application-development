package com.acme.dbo.txlog;

public class OutputDecorator implements Logger {

    private static String PRIMITIVE_PREFIX = "primitive: ";
    private static String CHAR_PREFIX = "char: ";
    private static String STRING_PREFIX = "string: ";
    private static String REFERENCE_PREFIX = "reference: ";

    private Logger logger;

    OutputDecorator(Logger logger) {
       this.logger = logger;
    }

    public void log(byte message) {
        logger.log(PRIMITIVE_PREFIX + message);
    }

    public void log(String message) {
        logger.log(STRING_PREFIX + message);
    }

    public void log(char message) {
        logger.log(CHAR_PREFIX + message);
    }

    public void log(int message) {
        logger.log(PRIMITIVE_PREFIX + message);
    }

    public void log(float message) {
        logger.log(PRIMITIVE_PREFIX + message);
    }

    public void log(boolean message) {
        logger.log(PRIMITIVE_PREFIX + message);
    }

    public void log(Object message) {
        logger.log(REFERENCE_PREFIX + message);
    }
}
