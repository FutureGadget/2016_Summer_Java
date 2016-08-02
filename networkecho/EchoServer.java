package networkecho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoServer implements Runnable{
    private Socket socket;
    private Room currentRoom;
    private Person currentPerson;
    public EchoServer(Socket s) {
        socket = s;
    }

    private void getUserInfo() {
        System.out.print("이름: ");
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        try {
            String name = rd.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try {
            getUserInfo();
            BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s;
            while (!(s=rd.readLine()).equals("/exit")) {
                // broadcast
            }
            rd.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
