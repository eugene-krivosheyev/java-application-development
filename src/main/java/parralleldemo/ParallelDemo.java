package parralleldemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class ParallelDemo {
    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();
        System.out.println(counter.getCounter());

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        range(0, 1_000_000).forEach(i ->
            threadPool.submit(counter::increment)
        );

        threadPool.shutdown();
        threadPool.awaitTermination(10, TimeUnit.SECONDS);


        System.out.println(counter.getCounter());
    }
}

/**
 * Visibility, Reordering: JMM
 */
class Counter {
    private volatile int counter = 0;
    private final Object monitor = new Object();
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void increment() {
        rwLock.writeLock().lock();
        try {
            counter++;
        } finally {
            rwLock.writeLock().unlock();
        }

    }

    public int getCounter() {
        rwLock.readLock().lock();
        try {
            return counter;
        } finally {
            rwLock.readLock().unlock();
        }
    }
}