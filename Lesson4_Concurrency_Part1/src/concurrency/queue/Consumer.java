package concurrency.queue;

public class Consumer implements Runnable {

    private Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
        Thread thread = new Thread(this, "Consumer ");
        thread.setDaemon(true);
        thread.start();
    }


    @Override
    public void run() {
        while (true) {
            queue.get();
        }
    }
}
