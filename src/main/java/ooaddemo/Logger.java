package ooaddemo;


public class Logger {
    //TODO: Creational problem
    private final MessageFilter filter = new SeverityMessageFilter(1);
    private final MessagePrinter printer = new FileMessagePrinter("log.txt");

    //Algo: OCP
    public void log(String message, int severity) { //0,1,2
        if (filter.filter(message, severity)) {
            printer.print(message);
//            System.out.println(filter.getThreshold());
        }
    }
}
