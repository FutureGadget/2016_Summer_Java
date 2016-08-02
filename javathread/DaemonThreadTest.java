package javathread;

import static java.lang.Thread.yield;

/**
 * Created by danwoo on 2016-08-01.
 */
public class DaemonThreadTest {
    public static void main(String[] args) {
        Thread t = new Thread(new MyDaemonThread());
        t.setDaemon(true); // Thread 를 생성한 Thread 에게 종속시킴.(부모 종료시 자식 모두 종료)
        t.start();
        System.out.println("main종료!");
    }
}

class MyDaemonThread implements Runnable {
    @Override
    public void run() {
        while(true) {
            System.out.println("Thread 동작중");
        }
    }
}
