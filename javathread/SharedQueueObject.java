package javathread;

import java.util.LinkedList;

/**
 * Created by danwoo on 2016-08-01.
 */
public class SharedQueueObject {
    LinkedList<Integer> list;
    private static SharedQueueObject object = new SharedQueueObject();
    public static Object monitor = new Object();

    private SharedQueueObject() {
        list = new LinkedList<>();
    }
    public static SharedQueueObject getInstance() {
        return object;
    }
    public int putData() {
        int tmp = Producer.data++;
        list.add(tmp);
        return tmp;
    }
    public int getData() {
        return list.poll();
    }
    public boolean isAvailable() {
        return !list.isEmpty();
    }
}
