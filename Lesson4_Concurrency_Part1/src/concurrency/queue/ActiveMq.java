package concurrency.queue;

import javax.swing.plaf.TableHeaderUI;

public class ActiveMq {

    public static void main(String[] args) throws InterruptedException {
        Queue queue = new Queue();
        new Producer(queue);
        new Consumer(queue);
        Thread.sleep(100);
    }
}
