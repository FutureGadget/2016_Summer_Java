package javathread.conpro;
/**
 * Created by danwoo on 2016-08-01.
 */
public class Main {
    public static void main(String[] args) {
        Queue queue = Queueimpl.getInstance();
        Thread[] con = new Thread[3];
        for (int i = 0; i < 3; ++i) {
            con[i] = new Thread(new Consumer(queue, "Consumer"+i));
            con[i].start();
        }
        Thread pro = new Thread(new Producer(queue));
        pro.start();

        try {
            Thread.sleep(2);
            pro.interrupt();
            Thread.sleep(2);
            for (int i = 0; i < 3; ++i) con[i].interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
