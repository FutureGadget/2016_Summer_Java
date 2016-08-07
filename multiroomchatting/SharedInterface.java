package networkecho;

import java.io.PrintWriter;
import java.net.Socket;

public interface SharedInterface {
    Room createRoom(String name);
    Room getRoomByName(String name);
    Room getRoomByIndex(int i);
    Room deleteRoom(String roomName);
    Person getPersonByName(String name);
    Person createPerson(String name, Socket socket, String roomName);
    Person deletePerson(String personName);
    void joinRoom(String roomName, Person person);
    void broadcast(PrintWriter w, String msg, String roomName, String person);
    void whisper(String msg, String roomName, String toName);
    void kick(String target_name, String roomName, String userName);
    String getRoomList();
    String getPersonList(String roomName);
    void switchRoom(String from, String to, String personName);
    int getNumberOfRooms();
}
