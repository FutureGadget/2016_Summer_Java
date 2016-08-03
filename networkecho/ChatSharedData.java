package networkecho;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ChatSharedData implements SharedInterface {
    private static SharedInterface chatSharedData = new ChatSharedData();
    private ArrayList<Room> rooms;

    @Override
    public int getNumberOfRooms() {
        return rooms.size();
    }

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
    public Person createPerson(String name, Socket socket, String roomName) {
        Room room = getRoomByName(roomName);
        Person p = new Person(name, socket);
        room.insertPerson(p);
        return p;
    }

    @Override
    public Room getRoomByName(String name) {
        for (Room r : rooms) {
            if (r.getName().equals(name)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public Person getPersonByName(String name) {
        for (Room r : rooms) {
            Person p = r.getPersonByName(name);
            if (p != null) return p;
        }
        return null;
    }

    @Override
    public Room deleteRoom(String roomName) {
        Room r = getRoomByName(roomName);
        if (r != null) {
            rooms.remove(r);
        }
        return r;
    }

    @Override
    public Person deletePerson(String personName) {
        for (Room r : rooms) {
            Person p = r.removePersonByName(personName);
            if (p != null) return p;
        }
        return null;
    }

    @Override
    public void broadcast(PrintWriter w, String msg, String roomName, String person) {
        Room r = getRoomByName(roomName);
        r.broadcast(w, msg, person);
    }

    @Override
    public void whisper(String msg, String roomName, String toName) {
        Room r = getRoomByName(roomName);
        Person p = r.getPersonByName(toName);
        try {
            if (p != null) {
                PrintWriter w = new PrintWriter(p.getSocket().getOutputStream());
                w.println(msg);
                w.flush();
                w.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void kick(String target_name, String roomName, String userName) {
        Person admin = getPersonByName(userName);
        PrintWriter w;
        if (admin.isAdmin()) {
            Room r = getRoomByName(roomName);
            Person p = r.removePersonByName(target_name);
            try {
                w = new PrintWriter(p.getSocket().getOutputStream());
                w.println("/exit");
                w.flush();
                w.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Room getRoomByIndex(int i) {
        return rooms.get(i-1);
    }

    @Override
    public String getRoomList() {
        int num = 1;
        if (rooms.size() == 0) {
            return "개설된 방이 없습니다.";
        }
        String roomList = "방 목록: " + "\n";
        for (Room r : rooms) {
            roomList += ((num++) + r.getName() + "\n");
        }
        return roomList;
    }

    @Override
    public String getPersonList(String roomName) {
        Room r = getRoomByName(roomName);
        return r.getPersonList();
    }

    @Override
    public void switchRoom(String from, String to, String personName) {
        Room f = getRoomByName(from);
        Room t = getRoomByName(to);
        Person p = f.removePersonByName(personName);
        t.insertPerson(p);
        try {
            PrintWriter w = new PrintWriter(p.getSocket().getOutputStream());
            w.println(f.getName() + " 에서" + t.getName() + " 으로 이동.");
            w.flush();
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void joinRoom(String roomName, Person person) {
        Room r = getRoomByName(roomName);
        if (r != null) {
            r.insertPerson(person);
        }
    }
}
