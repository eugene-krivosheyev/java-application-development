package com.acme.dbo.txlog.message.processor.aggregation;

import com.acme.dbo.txlog.message.ByteMessage;
import com.acme.dbo.txlog.message.MessageBase;

public class ByteAggregation extends AggregationBase<ByteMessage> {

    public ByteAggregation(ByteMessage initialValue) {
        super(initialValue);
    }

    @Override
    public boolean canAggregate(MessageBase message) {
        if (!super.canAggregate(message)) {
            return false;
        }

        ByteMessage byteMessage = (ByteMessage) message;
        int nextAggregation = (int) byteMessage.getValue() + getMessage().getValue();

        return nextAggregation < Byte.MAX_VALUE;
    }

    @Override
    protected ByteMessage doAggregation(ByteMessage aggregation, ByteMessage byteMessage) {
        return new ByteMessage((byte) (aggregation.getValue() + byteMessage.getValue()));
    }

}
