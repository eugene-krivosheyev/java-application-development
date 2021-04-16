package com.acme.dbo.txlog.message;

public interface DecoratingMessage {
    String getDecoratedMessage();

    DecoratingMessage accumulate(DecoratingMessage message);

    boolean isEqualType(DecoratingMessage message);
}
