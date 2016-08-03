package singleroomchatting;

import java.net.Socket;

/**
 * Created by danwoo on 2016-08-03.
 */
public interface SharedChatDataInterface {
    void broadcastMessage(String msg, String name);
    void deleteUser(ChatServerThread thread);
    void addUser(ChatServerThread thread);
    int getNumberOfUsers();
}
