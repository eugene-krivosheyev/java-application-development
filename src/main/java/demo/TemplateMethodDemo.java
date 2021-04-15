package demo;

import ooadrefactoring.Message;

public class TemplateMethodDemo {
    public static void main(String[] args) {
        Logger logger = new LoggerImpl1();
        logger.log(null);
    }
}

abstract class Logger {
    public void log(Message m) {
        //....
        //....
        this.step(); //Template Method [GoF]
        //....
        //....
    }

    protected abstract void step();
}

class LoggerImpl1 extends Logger {
    @Override
    protected void step() {
        System.out.println("1");
    }
}

class LoggerImpl2 extends Logger {
    @Override
    protected void step() {
        System.out.println("2");
    }
}