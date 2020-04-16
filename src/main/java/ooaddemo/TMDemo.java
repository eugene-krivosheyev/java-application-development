package ooaddemo;


public class TMDemo {
    public static void main(String[] args) {

    }
}

//TM

/**
 * Template Method
 */
abstract class MyLogger {
    private LogFilter filter;
//    IService service = Simple, HPDService

    public void log(String message) {
        //...
        if (filter.filter(message)) {
//            service.coreBusinesLogic(message);
        }
        //.....
    }

    protected abstract void coreBusinesLogic(String message);
}

class SimpleMyLogger extends MyLogger {
    private LogWriter saver;

    @Override
    protected void coreBusinesLogic(String message) {
        saver.write(message);
    }
}

class HPDecoratedMyLogger extends MyLogger {
    @Override
    protected void coreBusinesLogic(String message) {
        System.out.println();

    }
    //TODO FIXME
    private String decoreate(String message) {
        return "Harry Potter and " + message;
    }
}