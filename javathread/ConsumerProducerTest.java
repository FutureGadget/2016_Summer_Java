package javathread;

/**
 * Created by danwoo on 2016-08-01.
 */
public class ConsumerProducerTest {
    public static void main(String[] args) {
        Thread[] consumers = new Thread[3];
        for (int i = 0; i < 3; ++i) consumers[i] = new Thread(new Consumer(SharedQueueObject.getInstance()));
        Thread producer = new Thread(new Producer(SharedQueueObject.getInstance()));
        for (int i = 0; i < 3; ++i) consumers[i].start();
        producer.start();
        try {
            Thread.sleep(50);
            producer.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
