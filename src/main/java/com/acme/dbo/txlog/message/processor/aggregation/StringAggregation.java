package com.acme.dbo.txlog.message.processor.aggregation;

import com.acme.dbo.txlog.message.StringMessage;

public class StringAggregation extends AggregationBase<StringMessage> {

    public StringAggregation(StringMessage initialValue) {
        super(initialValue);
    }

    @Override
    protected StringMessage doAggregation(StringMessage aggregation, StringMessage stringMessage) {
        return new StringMessage(aggregation.getValue() + System.lineSeparator() + stringMessage.getValue());
    }

}


