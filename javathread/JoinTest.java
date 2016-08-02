package javathread;

/**
 * Created by danwoo on 2016-08-01.
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread t = new Thread(new MyJoin());
        t.start();
        try {
            t.join();   // Thread t 종료시점까지 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("메인 Thread 종료!!");
    }
}

class MyJoin implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("5초간 슬립");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
