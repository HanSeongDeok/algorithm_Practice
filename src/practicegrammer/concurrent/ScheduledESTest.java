package practicegrammer.concurrent;

import java.util.concurrent.*;

public class ScheduledESTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        // 1초 기다렸다가 2초마다 실행!
        executorService.scheduleAtFixedRate(getRunnable("Hello"),1 , 2, TimeUnit.SECONDS);
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
