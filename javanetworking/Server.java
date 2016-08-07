package networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by danwoo on 2016-08-02.
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        PrintWriter w = null;
        try {
            serverSocket = new ServerSocket(50000); // ServerSocket 은 클라이언트의 접속대기용, 접속시 Socket 객체 반환
            socket = serverSocket.accept();

            w = new PrintWriter(socket.getOutputStream());
            w.println(new Date().toLocaleString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                w.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}