package service;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    private static final int THREAD_COUNT = 6;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
        System.out.println("Начало");
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    Thread.sleep(500 + (int) (500 * Math.random()));
                    System.out.println("Поток №" + w + " - готов");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Работа завершена");
    }
}
