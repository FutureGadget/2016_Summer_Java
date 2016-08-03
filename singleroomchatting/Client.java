package singleroomchatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final int port = 33333;
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", port);

            // Get name from the User (Keyboard input)
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Your name : ");
            String name = reader.readLine();

            // Send name to the connection server
            PrintWriter w = new PrintWriter(socket.getOutputStream());
            w.println(name);
            w.flush();

            // Create Reader Thread
            Thread readerThread = new Thread(new ClientReaderThread(socket));
            readerThread.start();

            // This thread(main thread) will be the Writer Thread
            String keyboardInput;
            keyboardInput = reader.readLine();
            while (!keyboardInput.equals("/exit")) {
                w.println(keyboardInput);
                w.flush();
                keyboardInput = reader.readLine();
            }

            // Close the Client Socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientReaderThread implements Runnable {
    private Socket socket;
    private BufferedReader reader;
    public ClientReaderThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            String msg;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while ((msg=reader.readLine()) != null) {
                // Blocking method is unblocked when the the related I/O stream is closed when the Client socket is closed.
                System.out.println(msg);
            }
        } catch (IOException e) {
        }
    }
}