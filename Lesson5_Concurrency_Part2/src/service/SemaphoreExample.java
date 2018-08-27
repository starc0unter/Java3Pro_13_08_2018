package service;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {


    public static final int SEMAPHORE_PERMITS = 2;
    public static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(SEMAPHORE_PERMITS);
        for (int i = 0; i < THREAD_COUNT; i++) {
            int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + w + " before semaphore");
                    semaphore.acquire();
                    System.out.println("Thread " + w + " acquire resource");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Thread " + w + " release resource");
                    semaphore.release();
                }

            }).start();

        }

    }
}
