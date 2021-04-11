package com.acme.dbo.txlog;

import com.acme.dbo.txlog.domain.Message;

public class LoggerController {

    private Message currentStateValue;
    private Printer printer = new ConsolePrinter();

    public void log(Message newMessage) {
        if (currentStateValue == null) {
            currentStateValue = newMessage;
        } else if (newMessage.getClass() == currentStateValue.getClass() && !newMessage.shouldFlush(currentStateValue)) { //accum
            currentStateValue = currentStateValue.accumulate(newMessage);
        } else { //flush
            flush();
            currentStateValue = newMessage;
        }
        printer.print(currentStateValue.intermediate());
    }

    public void flush() {
        printer.print(currentStateValue.toString());
        currentStateValue.clear();
    }

    public void clearState(){
        currentStateValue = null;
    }
}
