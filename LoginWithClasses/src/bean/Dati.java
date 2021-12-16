package bean;


import java.util.*;
import javax.servlet.http.HttpSession;

public class Dati {

    private Map<String, Utente> users;
    private Map<String, Optional<HttpSession>> sessions;
    private List<String> groups;

public Dati(){

    groups=new ArrayList<>();
    groups.add("g0");
    groups.add("g1");
    groups.add("g2");
    groups.add("g3");
    groups.add("g4");

    //login
    users = new HashMap<>();
    users.put("admin", new Utente("admin","admin"));
    users.put("user1", new Utente("user1","user1",this.groups.get(1)));
    users.put("user2", new Utente("user2","user2",this.groups.get(2)));
    users.put("user3", new Utente("user3","user3",this.groups.get(3)));
    users.put("user4", new Utente("user4","user4",this.groups.get(4)));

    //sessioni
    sessions = new HashMap<>();
    sessions.put("admin", Optional.empty());
    sessions.put("user1", Optional.empty());
    sessions.put("user2", Optional.empty());
    sessions.put("user3", Optional.empty());
    sessions.put("user4", Optional.empty());
}

    public Map<String, Utente> getUsers() {
        return users;
    }

    public Map<String, Optional<HttpSession>> getSessions() {
        return sessions;
    }

    public List<String> getGroups() {
        return groups;
    }
}
