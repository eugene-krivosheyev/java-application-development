package com.acme.dbo.txlog;

public interface Decorator {
    String decorate(String subject);

    String decorate(String subject, int repetitions);
}
