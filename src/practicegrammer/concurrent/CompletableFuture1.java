package practicegrammer.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFuture1 {
    static class SharedData {
        int data = 10;
        public SharedData() {}
        public int getValue() {
            return data;
        }
        public void setValue(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 스레드 풀 1 생성
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        // 스레드 풀 2 생성
        ExecutorService executorService2 = Executors.newFixedThreadPool(1);
        // 데이터
        SharedData data = new SharedData();
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(11);
        // 작업 실행
       /* CompletableFuture.supplyAsync(() -> process1(data), executorService1)
                .thenAcceptAsync(i -> process2(data, i), executorService1).get();*/

        executorService1.execute(() -> {
            System.out.println(threadLocal);
            threadLocal.set(3);
            System.out.println(threadLocal.get()+ " " + Thread.currentThread().getName());
            threadLocal.set(2);
        });
        executorService1.execute(()-> {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(threadLocal.get() + " " + Thread.currentThread().getName());
        });
        executorService2.execute(()->{
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(threadLocal.get() + " " + Thread.currentThread().getName());
        });
        executorService1.shutdown();

        executorService1 = Executors.newFixedThreadPool(2);
        executorService1.execute(() -> {
            threadLocal.set(42);
            System.out.println("Task 1: " + threadLocal.get() + " " + Thread.currentThread().getName());
        });
        executorService1.execute(() -> {
            System.out.println("Task 2: " + threadLocal.get() + " " + Thread.currentThread().getName());
        });

        // 스레드 풀 종료
        executorService1.shutdown();
        executorService2.shutdown();

        System.out.println(threadLocal.get());
    }

    private static void process2(SharedData data, Integer i) {
        data.setValue(i);
        System.out.println(data.getValue() + " " +Thread.currentThread().getName());
    }

    private static int process1(SharedData data) {
        process2(data, 3);
        return 2;
    }
}
