package ooadrecap;


public class Controller {
    private Command currentState = null;
    private Saver saver;

    public Controller(Saver saver) {
        this.saver = saver;
    }

    public void log(Command command) {
        //Tell
        command.accumulate(currentState); //callback
        // vs Ask
        this.currentState = currentState.accumulate(command);
    }
}
