package ooaddemo;

public class LoggerController {
    private final Printer printer = new FilePrinter("out.txt"); //Creator [GRASP]
    private final MessageFilter filter = new SeverityMessageFilter(SeverityLevel.WARNING);

    public void log(String message, SeverityLevel severity) {
        if (filter.filter(message, severity)) {
            printer.print(message);
        }
    }
}
