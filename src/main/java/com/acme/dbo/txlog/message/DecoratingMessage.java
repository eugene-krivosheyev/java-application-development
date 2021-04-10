package com.acme.dbo.txlog.message;

public interface DecoratingMessage {
    String getDecoratedMessage();

    default DecoratingMessage accumulate(DecoratingMessage message) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    Object getBody();
}
