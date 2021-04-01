package ooaddemo;


public class Logger {
    //TODO: Creational problem -> Creational DP
    private final MessageFilter filter;
    private final MessagePrinter printer;

    //constructor DI
    public Logger(MessageFilter filter, MessagePrinter printer) {
        this.filter = filter;
        this.printer = printer;
    }

    //Algo: OCP
    public void log(String message, int severity) { //0,1,2
        if (filter.filter(message, severity)) {
            printer.print(message);
//            System.out.println(filter.getThreshold());
        }
    }
}
