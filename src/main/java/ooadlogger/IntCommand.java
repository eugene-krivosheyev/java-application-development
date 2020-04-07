package ooadlogger;

public class IntCommand implements Command { //IS-A
    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return Integer.toString(message);
    }
}
