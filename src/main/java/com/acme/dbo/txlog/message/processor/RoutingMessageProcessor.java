package com.acme.dbo.txlog.message.processor;

import com.acme.dbo.txlog.message.MessageBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class RoutingMessageProcessor implements MessageProcessor {

    private final Map<Class,MessageProcessor> classToProcessorMap = new HashMap<>();
    private final List<MessageProcessor> processors;

    public RoutingMessageProcessor(Map<Class,MessageProcessor> routing){
        classToProcessorMap.putAll(routing);
        processors = classToProcessorMap.entrySet().stream().map(kv->kv.getValue()).distinct().collect(Collectors.toList());
    }

    @Override
    public void setCallBack(Consumer<MessageBase> callback) {
        processors.forEach(p->p.setCallBack(callback));
    }

    @Override
    public void flush() throws IOException {
        processors.forEach(p-> {
            try {
                p.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void accept(MessageBase messageBase) {
        classToProcessorMap.get(messageBase.getClass()).accept(messageBase);
    }
}
