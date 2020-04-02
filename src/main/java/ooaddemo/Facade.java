package ooaddemo;

public class Facade {
    private static Controller controller = new Controller();

    public static void log(int m) {
        controller.log(new IntCommand());
    }

    //....
}
