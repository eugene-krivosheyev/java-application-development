package com.acme.dbo.txlog;

public interface Filter {
    boolean filter(Message message, SevertyLevel logLevel);
}
