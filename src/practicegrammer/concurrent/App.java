package practicegrammer.concurrent;

public class App {
    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
        System.out.println("Hello: " + Thread.currentThread().getName());
    }
    static class ThreadTest extends Thread{
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }
}
