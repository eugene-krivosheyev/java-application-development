package demo;

public class Demo {
    public static void main(String[] args) {
        Printer
                printer1 = new Printer("1"),
                printer2 = new Printer("2");

        printer1.print();
        printer2.print(); //Surprise!
    }
}

class Printer {
    private static String message = "0"; //Introduce global state with static field

    Printer(String message) {
        this.message = message; //Error-prone approach
    }

    public void print() {
        System.out.println(message);
    }
}
