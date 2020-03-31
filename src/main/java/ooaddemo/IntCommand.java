package ooaddemo;


public class IntCommand implements Command {
    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return Integer.toString(message);
    }

    @Override
    public String getDecoratedMessage() {
        return "prefix: " + getMessage();
    }
}
