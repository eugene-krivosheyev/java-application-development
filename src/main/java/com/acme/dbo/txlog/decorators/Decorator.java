package com.acme.dbo.txlog.decorators;

public interface Decorator {
    String decorate(String subject);

    String decorate(String subject, int count);
}
