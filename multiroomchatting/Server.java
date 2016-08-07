package networkecho;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int port = 50000;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while(!Thread.currentThread().isInterrupted()) {
                Socket s = serverSocket.accept();
                // 여러 명의 Client를 처리하기 위해 Thread 가 필요
                Thread serviceThread = new Thread(new EchoServer(s));
                serviceThread.start();
            }
            System.out.println("ConnectionServer is closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
