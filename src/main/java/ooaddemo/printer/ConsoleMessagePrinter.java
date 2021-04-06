package ooaddemo.printer;

import ooaddemo.domain.message.Message;

public class ConsoleMessagePrinter implements MessagePrinter {
    @Override
    public void print(Message message) {
        System.out.println(message.getDecoratedBody());
    }
}
