package demo;

public class SwitchAndCycleDemo {
    public static void main(String[] args) {
        if (f1()) {

        } else if(f2()) {

        } else {

        }

        int age = 30;
        switch(age) {
            case 20: {
                System.out.println("молодой еще!");
                break;
            }
            case 30:
                System.out.println("уже норм"); break;
            case 40:
                System.out.println("уже поздно"); break;
        }

        switch (1) {
            default: break;
            case 2: break;
        }

    }

    private static boolean f2() {
        return false;
    }

    private static boolean f1() {
        return false;
    }
}
