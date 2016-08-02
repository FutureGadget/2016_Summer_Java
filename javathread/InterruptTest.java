package javathread;

/**
 * Created by danwoo on 2016-08-01.
 */
public class InterruptTest {
    public static void main(String[] args) {
        MyInterruptThread runnable = new MyInterruptThread();
        Thread t1 = new Thread(runnable);
        t1.start();
        try {
            Thread.sleep(500); // Sleep the Main thread
        } catch (Exception e) {
        }
        t1.interrupt(); // Interrupt() 가 호출된다고 해서 바로 Thread 가 동작을 중지하는 것은 아니다.
    }
}

class MyInterruptThread implements Runnable {
    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()) { // .interrupt() 호출시 체크하여 중지해야 함.
                System.out.println("해당 쓰레드는 계속 수행중");
                //Thread.sleep(2000); // Sleep 동안에는 Interrupt 발생하면 Exception 발생.
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
