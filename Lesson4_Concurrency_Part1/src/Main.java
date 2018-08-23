import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello!");
//            }
//        };

//        Thread thread = new Thread(run);
//        Thread thread = new Thread(new MyRunnable());
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000L);
                System.out.println("Finish " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "MyThread");
//        thread.run();
        thread.setDaemon(true);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.sleep(100);
        System.out.println(thread.getPriority());
        thread.start();
        thread.join();
//        Thread.sleep(TimeUnit.SECONDS.toMillis(2));//2000

        int i = 100;



        new MyThread().start();
        System.out.println("Finish " + Thread.currentThread().getName());
        Future<?> submit = Executors.newCachedThreadPool().submit(() -> System.out.println("str"));

    }
}
