package bean;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Utente {

    private String username;
    private String password;
    private Optional<String> group;
    private Date passwordSet;
    private boolean expired;
    private int wrongPassword;
    private HttpSession session;

    public Utente(String usr,String passw,String group){
        if(group==null)
            this.group=Optional.empty();
        else
            this.group=Optional.of(group);
        this.username=usr;
        this.password=passw;
        this.passwordSet=new Date(System.currentTimeMillis());
        this.expired=false;
        this.wrongPassword=0;
    }

    public Utente(String usr,String passw){
        this(usr,passw,null);
    }

    public void setPassword(String password) {
        this.passwordSet=new Date(System.currentTimeMillis());
        this.password = password;
        this.expired=false;
        this.wrongPassword=0;
    }

    public void setGroup(Optional<String> group) {
        this.group = group;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Optional<String> getGroup() {
        return group;
    }

    public boolean isExpired() {
        return expired;
    }

    public void resetPassword(){
        this.password=null;
        expired=true;
    }

    public void checkPasswordAge(){
        expired= daysUntilExpired()<=0;
    }

    public void incWrongPassword(){
        this.wrongPassword++;
        if(this.wrongPassword>=3)resetPassword();
    }

    public long daysUntilExpired(){
        long diffMillis= Math.abs(new Date(System.currentTimeMillis()).getTime()-this.passwordSet.getTime());
        return 60-TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS);
    }
    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }
}
