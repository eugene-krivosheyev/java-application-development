package ooaddemo;

public class ConsoleMessagePrinter implements MessagePrinter {
    @Override
    public void print(Message message) {
        System.out.println(message.getDecoratedBody());
    }
}
