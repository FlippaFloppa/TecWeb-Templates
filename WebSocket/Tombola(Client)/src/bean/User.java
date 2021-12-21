package bean;

import javax.websocket.Session;

public class User {
    private String name;
    private Session session;

    public User(String name, Session session){
        this.name=name;
        this.session=session;
    }

    public String getName() {
        return name;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + getSession() + '\'' +
                ", session=" + getSession() +
                '}';
    }
}
