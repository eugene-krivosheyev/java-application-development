package ooaddemo;

public class Logger {
    private FilePrinter printer = new FilePrinter("out.txt");
    public void log(String message){
        if (filter(message)){
            printer.print(message);
        }
    }

    private boolean filter(String message) {
        return false;
    }
}
