package logger;

public class LoggerController {
    private Printer printer = new ConsolePrinter();

    public void logMessage(Message message){
        printer.print(message.toString());
    }

//    LoggerController (Printer printer)
//    {
//        this.printer
//    }
}
