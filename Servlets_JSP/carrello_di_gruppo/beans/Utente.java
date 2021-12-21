package beans;

import javax.servlet.http.HttpSession;

public class Utente {
	private String username;
	private String password;
	private String group="";
	private HttpSession session;
	private boolean terminato=false;
	
	public boolean isTerminato() {
		return terminato;
	}
	public void setTerminato(boolean terminato) {
		this.terminato = terminato;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	
	
}
