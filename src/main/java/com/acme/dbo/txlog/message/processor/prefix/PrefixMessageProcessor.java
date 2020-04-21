package com.acme.dbo.txlog.message.processor.prefix;

import com.acme.dbo.txlog.message.MessageBase;
import com.acme.dbo.txlog.message.processor.MessageProcessor;

import java.io.IOException;
import java.util.Map;
import java.util.function.Consumer;

public class PrefixMessageProcessor implements MessageProcessor {

    private Map<Class, String> messageToPrefixMap;
    private Consumer<MessageBase> callback;

    public PrefixMessageProcessor(Map<Class, String> messageToPrefixMap) {
        this.messageToPrefixMap = messageToPrefixMap;
    }

    @Override
    public void setCallBack(Consumer<MessageBase> callback) {
        this.callback = callback;
    }

    @Override
    public void accept(MessageBase message) {
        if (callback == null) {
            return;
        }

        String prefix = messageToPrefixMap.get(message.getClass());
        MessageBase messageToConsume = prefix != null ? new PrefixMessage(prefix, message) : message;
        callback.accept(messageToConsume);
    }

    @Override
    public void flush() throws IOException {
    }

}
