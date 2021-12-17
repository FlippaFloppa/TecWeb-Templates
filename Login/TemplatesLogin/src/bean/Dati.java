package bean;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpSession;

public class Dati {

    private Map<String, String> users;
    private Map<String, Optional<HttpSession>> sessions;
    private Map<String, String> groups;

public Dati(){

    //login
    users = new HashMap<>();
    users.put("admin", "admin");
    users.put("utente1", "utente1");
    users.put("utente2", "utente2");
    users.put("utente3", "utente3");

    //sessioni
    sessions = new HashMap<>();
    sessions.put("admin", Optional.empty());
    sessions.put("utente1", Optional.empty());
    sessions.put("utente2", Optional.empty());
    sessions.put("utente3", Optional.empty());

    //gruppi
    groups=new HashMap<>();
    groups.put("admin", "g0");
    groups.put("utente1", "g1");
    groups.put("utente2", "g2");
    groups.put("utente3", "g3");
}

    public Map<String, Optional<HttpSession>> getSessions() {
        return sessions;
    }

    public Map<String, String> getUsers() {
        return users;
    }

    public Map<String, String> getGroups() {
        return groups;
    }

}
