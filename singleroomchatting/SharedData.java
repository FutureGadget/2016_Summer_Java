package singleroomchatting;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * Singleton Object (Only one object can exist in the server memory.)
 */
public class SharedData implements SharedChatDataInterface {
    private ArrayList<ChatServerThread> users;
    private static SharedChatDataInterface sharedData = new SharedData();
    private final Object monitor = new Object();

    private SharedData(){
        users = new ArrayList<>();
    }

    @Override
    public int getNumberOfUsers() {
        return users.size();
    }

    // getInstance method to obtain singleton object.
    public static SharedChatDataInterface getInstance() {
        return sharedData;
    }

    @Override
    public void broadcastMessage(String msg, String name) {
        synchronized (monitor) {
            for (ChatServerThread t : users) {
                if (t.getName().equals(name)) continue;
                try {
                    PrintWriter w = new PrintWriter(t.getSocket().getOutputStream());
                    w.println(name + ":" + msg);
                    w.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteUser(ChatServerThread thread) {
        synchronized (monitor) {
            users.remove(thread);
        }
    }

    @Override
    public void addUser(ChatServerThread thread) {
        synchronized (monitor) {
            users.add(thread);
        }
    }
}
