package javathread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("쓰레드 실행중: "+ i);
        }
    }
}
