package networkecho;

import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by danwoo on 2016-08-03.
 */
public interface RoomInterface {
    Person getPersonByName(String name);
    Person removePersonByName(String name);
    void insertPerson(Person person);
    String getName();
    void broadcast(PrintWriter w, String msg, String person);
    String getPersonList();
    int getNumberOfPersons();
}
