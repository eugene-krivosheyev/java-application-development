package parralleldemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        threadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        threadPool.execute(() -> System.out.println("HW!!!!!"));

        threadPool.shutdown();
        threadPool.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("main");
    }
}
