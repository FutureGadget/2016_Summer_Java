package networkecho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReader implements Runnable{
    private Socket socket;
    private BufferedReader rd;
    public ClientReader (Socket s) {
        socket = s;
        try {
            rd = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        String s;
        try {
            while (!(s = rd.readLine()).equals("/exit")) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
