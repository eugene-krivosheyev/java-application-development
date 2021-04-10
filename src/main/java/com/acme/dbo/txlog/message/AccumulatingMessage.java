package com.acme.dbo.txlog.message;

public interface AccumulatingMessage {
    AccumulatingMessage accumulate(AccumulatingMessage message);
}
