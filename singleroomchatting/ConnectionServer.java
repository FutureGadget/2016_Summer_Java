package singleroomchatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionServer {
    private static final int port = 33333;
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(port);
            while(!Thread.currentThread().isInterrupted()) {
                Socket socket = s.accept();

                // Get nickname from the connected client.
                BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String nick = rd.readLine();

                // Create a service Thread with the user name and socket object.
                ChatServerThread chatServerThread = new ChatServerThread(socket, nick);
                Thread thread = new Thread(chatServerThread);
                SharedData.getInstance().addUser(chatServerThread);

                // Print number of current users.
                System.out.println(SharedData.getInstance().getNumberOfUsers() + " users are on the chat server.");
                thread.start();
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
