package ooaddemo;

/**
 *  Code reuse : responsibility delegation, inheritance
 *  also generic programming, HLF high level functions
 */

public class LoggerController extends ValidatingController {
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
        super.log(message, severity);
        if (filter.filter(message, severity)){
            printer.print(message);
        }
    }

}
