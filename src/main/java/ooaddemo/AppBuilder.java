package ooaddemo;

public class AppBuilder {
    public static void main(String[] args) {
        //GoF Mediator, Controller
        final Logger logger = new Logger(
                new MessageLengthLogFilter(10),
                new ConsoleLogWriter()
        );

        //GoF: Command
        //Command: dumb (DTO) | smart
        //Dumb command + Dumb entity + Stateless services = Anemic Domain Model
        //Domain Class : data + behavior + -services- = Rich Domain Model (OOP)
        logger.log(new StringCommand("message 1"), 2);
        logger.log(new StringCommand("message 2"), 2);
        logger.log(new IntCommand(1), 2);
        logger.log(new IntCommand(2), 2);
    }
}

class Facade {
    private Controller controller = new C();

    public static void log(int message) {
        controller.log(Commands.INT_COMMAND);
    }
}