import javax.swing.plaf.TableHeaderUI;
import java.awt.font.TextHitInfo;

public class Increment {

    private static Object lock = new Object();

    private volatile static Integer data = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    incrementValue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");
        t1.setDaemon(true);
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    incrementValue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2");
        t2.setDaemon(true);
        t1.start();
        t2.start();

        Thread.sleep(2000);
    }

    private static void incrementValue() throws InterruptedException {
        synchronized (lock) {
        System.out.println(Thread.currentThread().getName() + " data = " + data++);
            Thread.sleep(100);
        }
    }
}
