package networkecho;

import java.net.Socket;

/**
 * Created by danwoo on 2016-08-02.
 */
public class Person {
    private String name;
    private Socket socket;
    private boolean admin;
    public Person(String name, Socket socket) {
        this.name = name;
        this.socket = socket;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public Socket getSocket() {
        return socket;
    }
}
