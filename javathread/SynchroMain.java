package javathread;

/**
 * Created by danwoo on 2016-08-01.
 */
public class SynchroMain {
    public static void main(String[] args) {
        SharedObject object = SharedObject.getInstance();
        Thread t1 = new Thread(new MySynchro(object));
        Thread t2 = new Thread(new MySynchro(object));
    }
}

class MySynchro implements Runnable {
    private SharedObject object;

    public MySynchro (SharedObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.setName("test");
    }
}
