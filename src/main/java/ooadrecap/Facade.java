package ooadrecap;

public class Facade {
    private final static Controller controller = new Controller(new ConsoleSaver());

    public static void log(int message) {
        controller.log(new IntCommand(message));
    }

    public static void log(String message) {
        controller.log(new StringCommand(message));
        //...
    }
}
