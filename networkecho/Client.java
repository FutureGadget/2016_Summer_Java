package networkecho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket s = null;
        BufferedReader rd = null;
        BufferedReader rdStdin = null;
        PrintWriter w = null;
        try {
            s = new Socket("localhost", 50000); // Server IP + Server Port 로 Socket 생성
            rd = new BufferedReader(new InputStreamReader(s.getInputStream()));
            rdStdin = new BufferedReader(new InputStreamReader(System.in));
            w = new PrintWriter(s.getOutputStream());

            // Create reader thread
            Thread reader = new Thread(new ClientReader(s));
            reader.start();

            while (true) {
                String str = rdStdin.readLine();
                w.println(str);
                w.flush();
                if (str.equals("/exit")) {
                    reader.interrupt();
                    try {
                        reader.join(); // wait until the child thread is closed.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                w.close();
                s.close();
                rdStdin.close();
                rd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
