package com.acme.dbo.txlog.message.processor.aggregation;

import com.acme.dbo.txlog.message.MessageBase;
import com.acme.dbo.txlog.message.processor.MessageProcessor;

import java.util.HashMap;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;


public class AggregatingMessageProcessor implements MessageProcessor {

    private final Map<Class, Function<MessageBase, AggregationBase>> aggregatorFactory = new HashMap<>();

    private Consumer<MessageBase> callback;
    private AggregationBase aggregation;

    public AggregatingMessageProcessor(Map<Class, Function<MessageBase, AggregationBase>> aggregatorFactory) {
        this.aggregatorFactory.putAll(aggregatorFactory);
    }

    @Override
    public void setCallBack(Consumer<MessageBase> callback) {
        this.callback = callback;
    }

    @Override
    public void accept(MessageBase message) {

        if (aggregation != null && aggregation.canAggregate(message) && aggregation.tryAggregate(message)) {
            return;
        }

        AggregationBase newAggregation = createAggregation(message);
        if (aggregation != null) {
            notify(aggregation.getMessage());
        }

        if (newAggregation == null) {
            notify(message);
        }

        aggregation = newAggregation;
    }

    @Override
    public void flush() {
        if (aggregation == null) {
            return;
        }

        notify(aggregation.getMessage());
        aggregation = null;
    }


    private AggregationBase createAggregation(MessageBase message) {
        Function<MessageBase, AggregationBase> aggregationCreator = aggregatorFactory.get(message.getClass());
        if (aggregationCreator == null) {
            return null;
        }

        return aggregationCreator.apply(message);
    }


    private void notify(MessageBase message) {
        if (callback == null) {
            return;
        }
        callback.accept(message);
    }
}
