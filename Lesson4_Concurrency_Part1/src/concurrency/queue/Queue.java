package concurrency.queue;

import java.util.concurrent.locks.ReentrantLock;

public class Queue {

    int n;
    private boolean valueSet = false;

    public synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupt!!!");
            }
        }
        System.out.println(" Получено:" + n);
        valueSet = false;
        notifyAll();
        return n;
    }

    public synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupt!!!");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Отправлено: " + n);
        notifyAll();
    }
}
