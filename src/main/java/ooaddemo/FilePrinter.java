package ooaddemo;

public class FilePrinter {
    private String file;

    public FilePrinter(String file) {
        this.file = file;
    }

    public void print(String message) {
        System.out.println("to file: " + file + " > " + message);
    }
}
