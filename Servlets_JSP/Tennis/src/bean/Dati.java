package bean;

import java.util.HashMap;
import java.util.Map;


public class Dati {

    private Map<String, String> users;

    public Dati() {

        //login
        users = new HashMap<>();
        users.put("admin", "admin");
        users.put("utente1", "utente1");
        users.put("utente2", "utente2");
        users.put("utente3", "utente3");

    }

    public Map<String, String> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Dati{" +
                "users=" + getUsers() +
                '}';
    }
}
