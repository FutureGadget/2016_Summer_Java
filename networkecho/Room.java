package networkecho;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Room implements RoomInterface{
    String name;
    private ArrayList<Person> persons;

    @Override
    public String getName() {
        return name;
    }

    public Room(String name) {
        this.name = name;
        persons = new ArrayList<>();
    }

    @Override
    public String getPersonList() {
        String personList = "";
        for (Person p : persons) {
            personList += p.getName() + "\n";
        }
        return personList;
    }

    @Override
    public int getNumberOfPersons() {
        return persons.size();
    }

    @Override
    public Person getPersonByName(String name) {
        for (Person p : persons) {
            if (p.getName().equals(name)) return p;
        }
        return null;
    }
    @Override
    public void insertPerson(Person p) {
        persons.add(p);
    }

    @Override
    public void broadcast(PrintWriter w, String msg, String person) {
        for (Person p : persons) {
            if (p.getName().equals(person)) continue;
            try {
                w = new PrintWriter(p.getSocket().getOutputStream());
                w.println(person + ":" + msg);
                w.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Person removePersonByName(String name) {
        Person remove = null;
        for (Person p : persons) {
            if (p.getName().equals("name")) {
                remove = p;
            }
        }
        if (remove != null) {
            persons.remove(remove);
            return remove;
        }
        return null;
    }
}
