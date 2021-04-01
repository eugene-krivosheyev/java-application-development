package ooaddemo;

public class LoggerController {
    private FilePrinter printer = new FilePrinter("out.txt");
    private final SeverityMessageFilter filter = new SeverityMessageFilter(SeverityLevel.WARNING);

    public void log(String message, SeverityLevel severity){
        if (filter.filter(message, severity)){
            printer.print(message);
        }
    }

}
