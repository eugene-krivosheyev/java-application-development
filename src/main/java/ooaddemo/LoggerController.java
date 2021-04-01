package ooaddemo;

public class LoggerController {
    private final Printer printer;
    private final MessageFilter filter;

    /**
     * Constructor DI:
     * @param printer
     * @param filter
     */
    public LoggerController(Printer printer, MessageFilter filter) {
        this.printer = printer;
        this.filter = filter;
    }

    public void log(String message, SeverityLevel severity){
        if (filter.filter(message, severity)){
            printer.print(message);
        }
    }

}
