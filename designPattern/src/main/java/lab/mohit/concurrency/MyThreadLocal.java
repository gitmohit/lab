package lab.mohit.concurrency;

import sun.misc.Unsafe;

public class MyThreadLocal {
    private static ThreadLocal<Integer> threadLocalValue = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            System.out.println("Calling initValue " + Thread.currentThread().getName());
            return 0; // Initial value for each thread
        }
    };


    static class Task implements Runnable {
        @Override
        public void run() {
            // Incrementing the ThreadLocal value
            for (int i = 0; i < 5; i++) {
                int value = threadLocalValue.get();
                threadLocalValue.set(value + 1);
                System.out.println(Thread.currentThread().getName() + " - Value: " + threadLocalValue.get());
            }
        }
    }

    public static void main(String[] args) {
        // Creating multiple threads
        Thread thread1 = new Thread(new Task(), "Thread-1");
        Thread thread2 = new Thread(new Task(), "Thread-2");
        Thread thread3 = new Thread(new Task(), "Thread-3");

        // Starting the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
