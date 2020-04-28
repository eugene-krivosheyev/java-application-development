package codereusedemo;

public class FlyableDemo {
    public static void main(String[] args) {
        Human zhenya = new Human();
//        zhenya.doWork(???);
    }
}

class Plane {
    public void fly() {

    }
}

class Human extends Plane {
    public void doWork(Plane facility) {
        ///khjlfkgh
        facility.fly();
        ///lgkfhjlghk
    }
}

final class RichHuman extends Human {
    private final Plane personalPlane; //const
//    private BankAccount account;

    RichHuman(Plane personalPlane) {
        this.personalPlane = personalPlane;
    }

    @Override
    public final void doWork(Plane facility) {
        //????
        personalPlane.fly();
        //????
    }

//    protected BankAccount getAccount() throws IllegalAccessException {
//        throw new IllegalAccessException();
//        return $10;
//    }
}



class Car {
    private int km;

    public void run() {
        km++;
    }

    public int getKm() {
        return km;
    }
}

class SuperCar extends Car {
    private int pontsPerSec;
}

