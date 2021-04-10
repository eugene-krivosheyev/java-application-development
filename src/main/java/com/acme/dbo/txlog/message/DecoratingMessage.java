package com.acme.dbo.txlog.message;

public interface DecoratingMessage {
    String getDecoratedMessage();

    Object getBody();
}
