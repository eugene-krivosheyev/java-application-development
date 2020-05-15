package parralleldemo;

import java.util.LinkedList;

public class BlockingQueue<T> {
    private LinkedList<T> queue = new LinkedList<>();
    private Object monitor = new Object();

    public void push(T element) {
        synchronized (monitor) {
            queue.add(element);
            monitor.notifyAll();
            ///.....
        }
    }

    public T pop() {
        synchronized (monitor) {
            while (queue.isEmpty()) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) { }
            }
            return queue.remove(0);
        }
    }
}

class Demo {
    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue<Object> queue = new BlockingQueue<>();

        new Thread(() -> System.out.println(queue.pop())).start();
        Thread.sleep(3_000);
        new Thread(() -> queue.push("HW!!")).start();
    }
}

class Transaction {
    public void transfer(Account fromAcc, Account toAcc, int amount) {
        synchronized (fromAcc) {
            synchronized (toAcc) {
                fromAcc.decrement(amount);
                toAcc.increment(amount);
            }
        }
    }
}

class Account {
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void increment(int amount) {
        this.amount += amount;
    }

    public void decrement(int amount) {
        this.amount -= amount;
    }
}
