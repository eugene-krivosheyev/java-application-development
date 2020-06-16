package com.acme.dbo.txlog.message.processor.aggregation;


import com.acme.dbo.txlog.message.MessageBase;
import com.acme.dbo.txlog.message.StringMessage;

public class StringDeduplication extends AggregationBase<StringMessage> {

    public StringDeduplication(StringMessage initialValue) {
        super(new RepeatingStringMessage(initialValue.getValue()));
    }

    @Override
    public boolean canAggregate(MessageBase message) {
        if (!(message instanceof StringMessage)) {
            return false;
        }
        StringMessage stringMessage = (StringMessage) message;
        return getMessage().getValue().equals(stringMessage.getValue());
    }

    @Override
    protected RepeatingStringMessage doAggregation(StringMessage aggregation, StringMessage stringMessage) {

        RepeatingStringMessage repeatingMessage = (RepeatingStringMessage) aggregation;

        return new RepeatingStringMessage(stringMessage.getValue(), repeatingMessage.count() + 1);
    }
}
