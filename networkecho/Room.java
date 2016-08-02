package networkecho;

import java.util.ArrayList;

/**
 * Created by danwoo on 2016-08-02.
 */
public class Room {
    String name;
    private ArrayList<Person> persons;

    public String getName() {
        return name;
    }

    public Room(String name) {
        this.name = name;
        persons = new ArrayList<>();
    }

    public void insertPerson(Person p) {
        persons.add(p);
    }
    public void removePersonByName(String name) {
        Person remove = null;
        for (Person p : persons) {
            if (p.getName().equals("name")) {
                remove = p;
            }
        }
        if (remove != null) persons.remove(remove);
    }
}
