package demo;

public class TemplateMethodDemo {
    public static void main(String[] args) {

    }
}

class Logger {
    public void log(int m) {
        //....
        customStep1(); // delegate.customStep(); -> "Strategy"
        //....
    }

    public void log(String m) {
        //....
        customStep2(); // delegate.customStep();
        //....
    }

    private void customStep2() {

    }

    private void customStep1() {

    }
}
