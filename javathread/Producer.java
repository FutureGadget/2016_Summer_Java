package javathread;

/**
 * Created by danwoo on 2016-08-01.
 */
public class Producer implements Runnable{
    private SharedQueueObject object;
    public static int data = 0;
    public Producer(SharedQueueObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                synchronized (SharedQueueObject.monitor) {
                    System.out.println("Producer puts data: " + object.putData());
                    SharedQueueObject.monitor.notify();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
