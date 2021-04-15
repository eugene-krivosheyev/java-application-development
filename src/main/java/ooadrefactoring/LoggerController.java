package ooadrefactoring;

import java.io.PrintWriter;

/**
 * Inheritance = polymorphism + behavior reuse
 */
public class LoggerController extends AbstractController {
    private Printer printer;

    public LoggerController(Printer printer) {
        this.printer = printer;
    }

    @Override // documenting + check
    public void log(Message newMessage) {
        super.log(newMessage);

        Printer.newStaticMethod("");
        printer.newMethod();

        printer.print(newMessage.getDecoratedBody());
    }
}
