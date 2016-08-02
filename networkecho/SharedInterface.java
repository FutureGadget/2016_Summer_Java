package networkecho;

import java.net.Socket;

public interface SharedInterface {
    Room createRoom(String name);
    Person createPerson(String name, Socket socket);
    void joinRoom(Room r, Person p);
    void deleteRoom(Room r);
    void deletePerson(Person p);
    void broadcast(String msg, Room room);
    void whisper(String msg, Room room, String toName);
    void kick(String target_name, Room room, Person admin);
    String getRoomList();
    String getPersonList();
}
