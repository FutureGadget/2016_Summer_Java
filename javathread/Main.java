package javathread;

public class Main {
    public static void main(String[] args) {
        /*
         * Thread 만드는 방법 1.
         * Thread Class extend
         */
        Thread t1 = new MyThread();
        t1.start(); // Ready queue 에 thread 추가하는 method.
        System.out.println("Main thread 종료!");

        System.out.println("Thread2 시작");
        /*
         * Thread 만드는 방법 2. (More preferred)
         * implements Runnable interface
         */
        MyRunnable runnable = new MyRunnable();
        Thread t2 = new Thread(runnable);
        t2.run();
    }
}
