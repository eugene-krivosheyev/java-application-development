package com.acme.dbo.txlog.message.processor.aggregation;

import com.acme.dbo.txlog.message.IntMessage;
import com.acme.dbo.txlog.message.MessageBase;

public class IntAggregation extends AggregationBase<IntMessage> {

    public IntAggregation(IntMessage initialValue) {
        super(initialValue);
    }

    @Override
    public boolean canAggregate(MessageBase message) {
        if (!super.canAggregate(message)) {
            return false;
        }

        IntMessage intMessage = (IntMessage) message;
        long nextAggregation = (long) intMessage.getValue() + getMessage().getValue();

        return nextAggregation < Integer.MAX_VALUE;
    }

    @Override
    protected IntMessage doAggregation(IntMessage aggregation, IntMessage intMessage) {
        return new IntMessage(aggregation.getValue() + intMessage.getValue());
    }
}
