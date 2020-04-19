package com.acme.dbo.txlog.message.processor;

import com.acme.dbo.txlog.message.MessageBase;

import java.io.Flushable;
import java.util.function.Consumer;

public interface MessageProcessor extends Flushable, Consumer<MessageBase> {

    void setCallBack(Consumer<MessageBase> callback);
}
