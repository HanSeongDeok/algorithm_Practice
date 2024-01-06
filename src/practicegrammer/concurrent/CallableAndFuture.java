package practicegrammer.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            sleep(1000L);
            return "Hello";
        };

        Future<String> future = executorService.submit(callable);
        System.out.println("start");

        future.isDone();
        //future.cancel(false);
        future.get();

        System.out.println("end!");
        executorService.shutdown();
        executorService = Executors.newFixedThreadPool(3);

        Callable<String> hello = () -> {
            sleep(2000L);
            return "1. Hello";
        };

        Callable<String> java = () -> {
            sleep(3000L);
            return "2. java";
        };

        Callable<String> han = () -> {
            sleep(1000L);
            return "3. han";
        };

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, han));
        for (Future<String> f: futures) {
            System.out.println(f.get());
        }

        System.out.println(executorService.invokeAny(Arrays.asList(hello, java, han)));
        executorService.shutdown();
    }
}
