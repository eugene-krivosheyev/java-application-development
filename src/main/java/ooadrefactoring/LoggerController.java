package ooadrefactoring;

import java.io.PrintWriter;

public class LoggerController {
    private Printer printer;

    public LoggerController(Printer printer) {
        this.printer = printer;
    }

    public void log(Message newMessage) {
        Printer.newStaticMethod("");
        printer.newMethod();
        printer.print(newMessage.getDecoratedBody());
    }
}
