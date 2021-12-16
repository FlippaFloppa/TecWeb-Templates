package servlets;

import bean.Dati;
import bean.Utente;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;


public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Dati d;

    @Override
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
        //dati con scope application
        d = (Dati) getServletContext().getAttribute("dati");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String r = req.getParameter("req");

        if (r.equals("login")) {
            if (checkLogin(username, password, req.getSession())) {
                getServletContext().getRequestDispatcher("/carrello.jsp").forward(req, resp);
                System.out.println("Ricevuto login da Username: " + username + " Password: " + password);
            } else {
                getServletContext().getRequestDispatcher("/errors/loginFailure.jsp?err=login").forward(req, resp);
            }
        }
        if (r.equals("registration")) {
            String group = req.getParameter("group");
            System.out.println("Ricevuta registrazione da Username: " + username + " Password: " + password+" Gruppo: "+group);

            if (registration(username, password, group)) {
                getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/errors/loginFailure.jsp?err=registration").forward(req, resp);
            }
        }

    }

    public boolean registration(String username, String password, String group) {
        //controllo che il gruppo sia tra quelli disponibili
        if (d.getGroups().contains(group) && !d.getUsers().containsKey(username)) {
            d.getUsers().put(username, new Utente(username,password,group));
            d.getSessions().put(d.getUsers().get(username).getUsername(), Optional.empty());
            System.out.println("Registrato utente: " + username + ", gruppo: " + group);
            return true;
        }
        return false;
    }

    public boolean checkLogin(String username, String password, HttpSession s) {
        //controllo che nome e password corrispondano
        if (d.getUsers().containsKey(username) && d.getUsers().get(username).getPassword().compareTo(password)==0) {
            //controllo che non ci sia la sessione per quell'utente
            if(s.isNew()){
                return true;
            }else if (d.getSessions().get(username).isEmpty()) {
                System.out.println("Loggato utente: " + username);
                d.getSessions().put(d.getUsers().get(username).getUsername(), Optional.of(s));
                return true;
            }
        }
        return false;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    }
}
