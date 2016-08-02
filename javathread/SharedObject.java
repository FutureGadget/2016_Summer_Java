package javathread;

/**
 * Created by danwoo on 2016-08-01.
 */

/*
 * Singleton 프로그램 실행 중 memory 내에 오직 1개의 객체만 존재
 */
public class SharedObject {
    private String name;
    private Object monitor = new Object();

    //singleton
    private static SharedObject sharedObject = new SharedObject();

    // Private constructor (singleton)
    private SharedObject() {

    }

    public static SharedObject getInstance() {
        return sharedObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        synchronized (monitor) {
            this.name = name;
            try {
                monitor.wait(); // 명시적으로 모니터를 반환할 수 있음.
//                monitor.notify(); // Block 되고 깨어남
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Object getMonitor() {
        return monitor;
    }

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
    }
}
