package ooaddemo;

public class FileMessagePrinter implements MessagePrinter {
    private final String filename;

    public FileMessagePrinter(String filename) {
        this.filename = filename;
    }

    @Override
    public void print(String message) {
        System.out.println("file: " + filename + ", message: " + message);
    }
}
