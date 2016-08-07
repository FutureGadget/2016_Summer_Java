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
            while (!Thread.currentThread().isInterrupted()) {
                s = rd.readLine();
                if (s.equals("/exit")) {
                    break;
                }
                System.out.println(s);
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
