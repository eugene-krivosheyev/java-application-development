package com.acme.dbo.txlog;


public class Controller {

    LogWriter logWriter;
    private Command currentState;

    public Controller(LogWriter logWriter) {
        this.logWriter = logWriter;
    }

    public void log(Command command) {
        if (command.isSame(currentState)) {
            this.currentState = command.updateState(currentState);
        } else {
            flush();
            this.currentState = command;
        }

    }

    public void flush() {
        if (this.currentState != null) {
            logWriter.write(this.currentState);
        }

    }



 /*   static void log(Object msg, MsgType type) {
        switch (type) {
            case INT:
                DecoratorInt.decorate(msg);
                break;
            case STR:
                DecoratorString.decorate(msg);
                break;
            case BYTE:
                DecoratorByte.decorate(msg);
                break;
        }

    }

    ;

    enum MsgType {
        INT, STR, BYTE
    }
*/;
//non-static method cannot be referenced from static context
}
