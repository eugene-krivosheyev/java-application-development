package ooadlogger;

public class StringCommand implements Command {
    private String message;

    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
