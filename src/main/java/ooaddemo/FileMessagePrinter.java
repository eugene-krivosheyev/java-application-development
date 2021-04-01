package ooaddemo;

public class FileMessagePrinter {
    private final String filename;

    public FileMessagePrinter(String filename) {
        this.filename = filename;
    }

    public void print(String message) {
        System.out.println("file: " + filename + ", message: " + message);
    }
}
