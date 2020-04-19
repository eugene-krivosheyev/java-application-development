package com.acme.dbo.txlog;

public interface LogDecorator {

    String decorate(Command command);

    void setDecorated(boolean decorated);
}
