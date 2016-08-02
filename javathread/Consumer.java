package javathread;

/**
 * Created by danwoo on 2016-08-01.
 */
public class Consumer implements Runnable {
    public SharedQueueObject object;
    public Consumer (SharedQueueObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (SharedQueueObject.monitor) {
                if (!SharedQueueObject.getInstance().isAvailable()) {
                    try {
                        SharedQueueObject.monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int tmp = object.getData();
                System.out.println("Consumer gets data: " + tmp);
            }
        }
    }
}
