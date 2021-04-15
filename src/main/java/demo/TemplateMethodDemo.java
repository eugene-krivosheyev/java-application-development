package demo;

import ooadrefactoring.Message;

public class TemplateMethodDemo {
    public static void main(String[] args) {
        // 1MSLoc
        Logger logger = new LoggerImpl1();
        logger.log(null);
    }
}

abstract class Logger {
    public void log(Message m) {
        // 1MSLoc
        //....
        //....
        try {
            final Number stepResult = this.step();//Template Method [GoF]
        } catch (IllegalArgumentException e) {}
        //....
        //....
    }
    protected abstract Number step() throws IllegalArgumentException;
}

class LoggerImpl1 extends Logger  { //IS-A
    @Override
    protected Integer step()  {
        System.out.println("1");
        return null;
    }
}

class LoggerImpl2 extends Logger {
    @Override
    protected Number step() {
        System.out.println("2");
        return null;
    }
}