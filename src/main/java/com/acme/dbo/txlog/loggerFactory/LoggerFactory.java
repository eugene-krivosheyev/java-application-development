package com.acme.dbo.txlog.loggerFactory;

public class LoggerFactory implements Logger {


    public static Logger createLogger(loggerType type) {
        Logger logger = null;
        switch (type) {
            case BYTE: logger = new ByteLogger();
                    break;
            case STRING: logger = new StringLogger();
                    break;
            case INTEGER: logger = new IntegerLogger();
                    break;
            default: break;
        }
        return logger;
    }
}
