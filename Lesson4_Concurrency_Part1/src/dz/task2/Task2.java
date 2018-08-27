package dz.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task2 {

    public static final int LINE_COUNT = 10;

    public static void main(String[] args) throws IOException, InterruptedException {
        List<Thread> workers = new ArrayList<>();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("task2.txt")))) {
            executorService.scheduleAtFixedRate(() -> writeToFile("aaaaa", out), 0, 20, TimeUnit.MILLISECONDS);
            executorService.scheduleAtFixedRate(() -> writeToFile("bbbbb", out), 0, 20, TimeUnit.MILLISECONDS);
            executorService.scheduleAtFixedRate(() -> writeToFile("ccccc", out), 0, 20, TimeUnit.MILLISECONDS);
//            workers.add( new Thread(() -> writeToFile("aaaaa", out)) );
//            workers.add( new Thread(() -> writeToFile("bbbbb", out)) );
//            workers.add( new Thread(() -> writeToFile("ccccc", out)) );
//
//            workers.forEach(worker -> worker.setDaemon(true));
//            workers.forEach(Thread::start);
            Thread.sleep(1000);
        }
        executorService.shutdown();
    }


    private static void writeToFile(String textLine, PrintWriter out) {
        try {
            for (int i = 0; i < LINE_COUNT; i++) {
                out.println(textLine);
            }
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
