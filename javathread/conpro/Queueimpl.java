package javathread.conpro;

import java.util.LinkedList;

/**
 * Created by danwoo on 2016-08-01.
 */
public class Queueimpl implements Queue{
    private static Queueimpl queue = new Queueimpl();
    private static final Object monitor = new Object();

    private LinkedList<String> list = new LinkedList<String>();
    private Queueimpl() {

    }
    public static Queue getInstance() {
        return queue;
    }
    @Override
    public void put(String num) {
        synchronized (monitor) {
            list.add(num);
            monitor.notify();
        }
    }

    @Override
    public String get() {
        String result = null;
        synchronized (monitor) {
            if (list.isEmpty()) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                result = list.poll();
            }
        }
        return result;
    }
}
