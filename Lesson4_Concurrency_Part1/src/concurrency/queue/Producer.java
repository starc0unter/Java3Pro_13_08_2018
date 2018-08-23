package concurrency.queue;

public class Producer implements Runnable {

    private Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
        Thread thread = new Thread(this, "Producer ");
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            queue.put(i++);
        }
    }
}
