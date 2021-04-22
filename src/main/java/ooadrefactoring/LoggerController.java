package ooadrefactoring;

import java.io.PrintWriter;
import java.util.function.Consumer;

/**
 * Inheritance = polymorphism + behavior reuse
 */
public class LoggerController extends AbstractController {
    private Consumer<String> printer;

    public LoggerController(Consumer<String> printer) {
        this.printer = printer;
    }

    @Override // documenting + check
    public void log(Message newMessage) {
        super.log(newMessage);

        Printer.newStaticMethod("");
        printer.accept(newMessage.getDecoratedBody());
    }
}
