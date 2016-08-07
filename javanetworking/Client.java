package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by danwoo on 2016-08-02.
 */
public class Client {
    public static void main(String[] args) {
        Socket s = null;
        BufferedReader rd = null;
        try {
            s = new Socket("localhost", 50000); // Server IP + Server Port 로 Socket 생성
            rd = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String date = rd.readLine(); // blocking method (Stream에 있을 때 까지 대기)
            System.out.println(date);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                rd.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
