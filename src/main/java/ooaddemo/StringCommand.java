package ooaddemo;

public class StringCommand implements Command {
    private String message;

    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getDecoratedMessage() {
        return "prefix: " + message;
    }
}
