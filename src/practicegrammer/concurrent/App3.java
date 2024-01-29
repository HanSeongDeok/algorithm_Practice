package practicegrammer.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            System.out.println("Thread " + Thread.currentThread().getName());
        });
        executorService.shutdown();
    }
}
