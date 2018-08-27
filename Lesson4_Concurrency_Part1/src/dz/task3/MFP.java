package dz.task3;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MFP {

    private Object printLock = new Object();
    private Object scanLock = new Object();

    private int printedPages;
    private int scannedPages;

    public void print() {
        synchronized (printLock) {
            System.out.println(String.format("%s: Отпечатано %s",
                    Thread.currentThread().getName(),
                    generatePageNumberSequence(++printedPages)));
        }
    }
    public void scan() {
        synchronized (scanLock) {
            System.out.println(String.format("%s: Отсканировано %s",
                    Thread.currentThread().getName(),
                    generatePageNumberSequence(++scannedPages)));
        }
    }

    private String generatePageNumberSequence(int pageCount) {
        return IntStream.rangeClosed(1, pageCount)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
