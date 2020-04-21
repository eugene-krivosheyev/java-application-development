package com.acme.dbo.txlog.message.processor.aggregation;

import com.acme.dbo.txlog.message.MessageBase;

public abstract class AggregationBase<TMessage extends MessageBase> {

    private TMessage aggregation;

    public AggregationBase(TMessage initialValue) {
        this.aggregation = initialValue;
    }

    public boolean tryAggregate(TMessage message) {
        if (!canAggregate(message)) {
            return false;
        }
        aggregation = doAggregation(aggregation, message);
        return true;
    }

    public TMessage getMessage() {
        return aggregation;
    }

    protected boolean canAggregate(MessageBase message) {
        return aggregation.getClass().equals(message.getClass());
    }

    protected abstract TMessage doAggregation(TMessage aggregation, TMessage message);
}
