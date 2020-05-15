package parralleldemo;

public class ParallelDemo {
    public static void main(String[] args) {
        final MyWorker myWorker = new MyWorker();
        //....
        myWorker.start();
        while (true) {
            System.out.println("main");
        }
    }
}

class MyWorker extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(this.getName());
        }
    }
}