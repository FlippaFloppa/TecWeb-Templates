package bean;

import org.hsqldb.rights.User;

import java.util.Optional;

public class Utente {

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Optional<String> getGroup() {
        return group;
    }

    private String username;
    private String password;
    private Optional<String> group;

    public Utente(String usr,String passw,String group){
        this.username=usr;
        this.password=passw;
        this.group=Optional.of(group);
    }

    public Utente(String usr,String passw){
        this.username=usr;
        this.password=passw;
        this.group=Optional.empty();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGroup(Optional<String> group) {
        this.group = group;
    }

}
