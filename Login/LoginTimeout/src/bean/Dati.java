package bean;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class Dati {

    private Map<String, String> users;
    private final TreeMap<String, Optional<HttpSession>> sessions;
    private final Map<String, Group> groups;

    public Dati() {

        //login
        users = new HashMap<>();
        users.put("admin", "admin");
        users.put("utente1", "utente1");
        users.put("utente2", "utente2");
        users.put("utente3", "utente3");

        //sessioni
        sessions = new TreeMap<>();
        sessions.put("admin", Optional.empty());
        sessions.put("utente1", Optional.empty());
        sessions.put("utente2", Optional.empty());
        sessions.put("utente3", Optional.empty());

        //gruppi
        groups = new HashMap<>();
        groups.put("admin", new Group("g0"));
        groups.put("utente1", new Group("g1"));
        groups.put("utente2", new Group("g2"));
        groups.put("utente3", new Group("g3"));
    }

    public Map<String, Optional<HttpSession>> getSessions() {
        return sessions;
    }

    public Map<String, String> getUsers() {
        return users;
    }

    public Map<String, Group> getGroups() {
        return groups;
    }

}
