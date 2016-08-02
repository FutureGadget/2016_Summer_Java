package javathread.conpro;

/**
 * Created by danwoo on 2016-08-01.
 */
public class Consumer implements Runnable {
    private Queue queue;
    private String name;
    public Consumer(Queue queue, String name) {
        this.queue = queue;
        this.name = name;
    }
    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()) {
                System.out.println(name + " : " + queue.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Consumer : " + name + " 종료!");
        }
    }
}
