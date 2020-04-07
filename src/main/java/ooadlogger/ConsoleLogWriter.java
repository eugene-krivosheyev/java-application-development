package ooadlogger;

public class ConsoleLogWriter implements LogWriter {
    @Override
    public void write(Command command) {
        System.out.println(command);
    }
}
