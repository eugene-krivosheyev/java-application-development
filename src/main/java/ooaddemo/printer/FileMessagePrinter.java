package ooaddemo.printer;

import ooaddemo.domain.message.Message;

public class FileMessagePrinter implements MessagePrinter {
    private final String filename;

    public FileMessagePrinter(String filename) {
        this.filename = filename;
    }

    @Override
    public void print(Message message) {
        System.out.println("file: " + filename + ", message: " + message.getDecoratedBody());
    }
}
