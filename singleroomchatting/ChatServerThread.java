package singleroomchatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatServerThread implements Runnable {
    private String name;
    private Socket socket;
    private BufferedReader reader;

    public String getName() {
        return name;
    }

    public Socket getSocket() {
        return socket;
    }

    public ChatServerThread(Socket socket, String name) {
        this.name = name;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Open Input Stream to get inputs from the client.
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msgFromClient;

            // Do until the client socket is closed.
            while ((msgFromClient = reader.readLine()) != null) {
                // Broadcast message to the other clients.
                SharedData.getInstance().broadcastMessage(msgFromClient, name);
            }
            // Remove this thread from the server when the client socket is closed.
            SharedData.getInstance().deleteUser(this);
            System.out.println("Socket reset.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
