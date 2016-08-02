package networkecho;

import java.net.Socket;
import java.util.ArrayList;

public class ChatSharedData implements SharedInterface {
    private static SharedInterface chatSharedData = new ChatSharedData();
    private ArrayList<Room> rooms;

    private ChatSharedData() {
        rooms = new ArrayList<>();
    }

    public static SharedInterface getInstance() {
        return chatSharedData;
    }

    @Override
    public Room createRoom(String name) {
        Room r = new Room(name);
        rooms.add(r);
        return r;
    }

    @Override
    public Person createPerson(String name, Socket socket) {
        Person p = new Person(name, socket);
        return p;
    }

    @Override
    public void joinRoom(Room r, Person p) {
        Room room = null;
        for (Room rm : rooms) {
            if (rm.getName().equals(r.getName())) {
                room = rm;
                break;
            }
        }
        if (room != null) room.insertPerson(p);
    }

    @Override
    public void deleteRoom(Room r) {

    }

    @Override
    public void deletePerson(Person p) {

    }

    @Override
    public void broadcast(String msg, Room room) {

    }

    @Override
    public void whisper(String msg, Room room, String toName) {

    }

    @Override
    public void kick(String target_name, Room room, Person admin) {

    }

    @Override
    public String getRoomList() {
        return null;
    }

    @Override
    public String getPersonList() {
        return null;
    }
}
