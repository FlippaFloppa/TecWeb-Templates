package bean;


import java.util.*;
import javax.servlet.http.HttpSession;

public class Dati {

    private Map<String, Utente> users;

public Dati(){

    //login
    users = new HashMap<>();
    users.put("admin", new Utente("admin","admin"));
    users.put("user1", new Utente("user1","user1"));
}

    public Map<String, Utente> getUsers() {
        return users;
    }
}
