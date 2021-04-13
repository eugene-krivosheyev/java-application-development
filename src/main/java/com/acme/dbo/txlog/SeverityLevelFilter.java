package com.acme.dbo.txlog;

public class SeverityLevelFilter implements Filter {
    private final SevertyLevel level;

    public SeverityLevelFilter(SevertyLevel level) {
        this.level = level;
    }

    @Override
    public boolean filter(Message message, SevertyLevel logLevel) {
        return logLevel.compareTo(level) < 0;
    }
}
