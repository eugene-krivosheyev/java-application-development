package parralleldemo;

public class ParallelDemo {
    public static void main(String[] args) {
        final Thread myWorker = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });
        //....
        myWorker.start();
        while (true) {
            System.out.println("main");
        }
    }
}
