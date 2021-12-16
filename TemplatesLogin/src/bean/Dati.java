package bean;


import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

public class Dati {

    private Map<String, String> map;
    private Map<String, HttpSession> sessions;

public Dati(){

    //login
    map = new HashMap<>();
    map.put("admin", "admin");
    map.put("utente1", "utente1");
    map.put("utente2", "utente2");
    map.put("utente3", "utente3");

    //sessioni
    sessions = new HashMap<>();
    sessions.put("admin", null);
    sessions.put("utente1", null);
    sessions.put("utente2", null);
    sessions.put("utente3", null);
}

    public Map<String, HttpSession> getSessions() {
        return sessions;
    }

    public Map<String, String> getMap() {
        return map;
    }

}
