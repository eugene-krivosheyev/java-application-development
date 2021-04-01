package ooaddemo;


public class Logger {
    //TODO: Creational problem -> Creational DP
    private final MessageFilter filter = new SeverityMessageFilter(1); //Creator [GRASP]
    private final MessagePrinter printer = new FileMessagePrinter("log.txt");

    //Algo: OCP
    public void log(String message, int severity) { //0,1,2
        if (filter.filter(message, severity)) {
            printer.print(message);
//            System.out.println(filter.getThreshold());
        }
    }
}
