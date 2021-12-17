package bean;


import java.util.*;
import javax.servlet.http.HttpSession;

public class Dati {

    private Map<String, Utente> users;
    private Map<String,List<Utente>> groups;

public Dati(){

    groups=new HashMap<>();
    groups.put("g0",new ArrayList<>());
    groups.put("g1",new ArrayList<>());
    groups.put("g2",new ArrayList<>());
    groups.put("g3",new ArrayList<>());
    groups.put("g4",new ArrayList<>());

    //login
    users = new HashMap<>();
    users.put("admin", new Utente("admin","admin"));
    users.put("user1", new Utente("user1","user1","g0"));
    users.put("user2", new Utente("user2","user2","g0"));
    users.put("user3", new Utente("user3","user3","g1"));
    users.put("user4", new Utente("user4","user4","g2"));

    // Inserimento persone neu gruppi
    groups.get("g0").add(this.getUsers().get("user1"));
    groups.get("g0").add(this.getUsers().get("user2"));
    groups.get("g1").add(this.getUsers().get("user3"));
    groups.get("g2").add(this.getUsers().get("user4"));

}

    public Map<String, Utente> getUsers() {
        return users;
    }

    public Map<String,List<Utente>> getGroups() {
        return groups;
    }
}
