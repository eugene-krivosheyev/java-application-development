package demo;

public class TemplateMethodDemo {
    public static void main(String[] args) {
        AbstractLogger logger = new CustomLogger1();
        logger.log();
    }
}

abstract class AbstractLogger {
    public void log() {
        //....
        this.customStep();
        //....
    }

    protected abstract void customStep();
}

class CustomLogger1 extends AbstractLogger {
    @Override
    protected void customStep() {
        System.out.println("1");
    }
}

class CustomLogger2 extends AbstractLogger {
    @Override
    protected void customStep() {
        System.out.println("2");
    }
}
