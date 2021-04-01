package ooaddemo;


public class Logger {
    //TODO: Creational problem
    private SeverityMessageFilter filter = new SeverityMessageFilter(1);
    private FileMessagePrinter printer = new FileMessagePrinter("log.txt");

    //Algo
    public void log(String message, int severity) { //0,1,2
        if (filter.filter(message, severity)) {
            printer.print(message);
        }
    }
}
