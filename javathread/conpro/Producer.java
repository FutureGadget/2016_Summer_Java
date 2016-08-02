package javathread.conpro;

/**
 * Created by danwoo on 2016-08-01.
 */
public class Producer implements Runnable {
    Queue queue;
    public Producer (Queue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        int i = 0;
        System.out.println("Producer 시작!!");
        try {
            // Thread 의 종료를 위해
            while(!Thread.currentThread().isInterrupted()) {
                queue.put(Integer.toString(i++));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Producer 종료!!");
        }
    }
}
