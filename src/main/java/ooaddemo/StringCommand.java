package ooaddemo;

public class StringCommand implements Command {
    private String message;

    public StringCommand(String message) {
        this.message = message;
    }
}
