package com.acme.dbo.txlog.message;

public interface Message {
    String getDecoratedMessage();
    boolean equalType(Message message);
    Message accumulate(Message message);
//    String getMessage();
}
