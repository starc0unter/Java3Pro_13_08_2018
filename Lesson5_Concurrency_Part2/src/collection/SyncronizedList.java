package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SyncronizedList {

    public static void main(String[] args) throws InterruptedException {
        List<String> data = new CopyOnWriteArrayList<>();

        Thread producer = createProducer(data);
        Thread reader = createReader(data);

        producer.start();
        reader.start();

        Thread.sleep(5000);
    }

    private static Thread createReader(List<String> data) {
        Thread reader = new Thread(() -> {
            while (true) {
//                List<String> snapshot = new ArrayList<>();
//                synchronized (data) {
//                    snapshot.addAll(data);
//                }

                for (String datum : data) {
                    System.out.println(datum);
                }
//                data.forEach(System.out::println);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        reader.setDaemon(true);
        return reader;
    }

    private static Thread createProducer(List<String> data) {
        Thread producer = new Thread(() -> {
           while (true) {
               data.add(String.valueOf(Math.random()));
               try {
                   Thread.sleep(10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        producer.setDaemon(true);
        return producer;
    }

}
