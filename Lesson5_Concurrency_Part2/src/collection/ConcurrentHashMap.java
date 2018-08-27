package collection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentHashMap {

    public static final int THREADS = 10;
    public static final int TASK_COUNT = 100;

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        Map<String, Long> map = new java.util.concurrent.ConcurrentHashMap<>();
//        map.put("test", 0L);
//        map.put("hex", 0L);

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

        try (BufferedReader reader = new BufferedReader(new FileReader("map_test.txt"))) {
            Callable<Long> task = () -> {
                String word = null;
                try {
                    word = reader.readLine();
                    if (word == null)
                        return 0L;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Long oldValue;
                    Long newValue;



//                    do {
                    map.merge(word, 1L, Long::sum);
//                        LongAdder value = map.computeIfAbsent(word, k -> new LongAdder());
//                        value.increment();
//                        oldValue = map.get(word);
//                        newValue = oldValue == null ? 1 : oldValue + 1;
                        Thread.sleep(10);
//                        map.put(word, newValue);
//                    } while (!map.replace(word, oldValue, newValue));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return map.get(word).longValue();

            };

            List<Future<Long>> futures = new ArrayList<>();

            for (int i = 0; i < TASK_COUNT; i++) {
                futures.add(executorService.submit(task));
            }

            Thread.sleep(2000);

            for (Future<Long> future : futures) {
                Long value = future.get();
            }

            System.out.println("'test' count is " + map.get("test"));
            System.out.println("'hex' count is " + map.get("hex"));

            executorService.shutdown();


        }

    }

}
