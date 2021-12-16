package servlets;

import bean.Dati;
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
    private boolean checkLogin = false;
    private boolean checkGroup = false;

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
            checkLogin = checkLogin(username, password, req.getSession());
            if (checkLogin) {
                getServletContext().getRequestDispatcher("/carrello.jsp").forward(req, resp);
                System.out.println("Ricevuto login da Username: " + username + " Password: " + password);
            } else {
                getServletContext().getRequestDispatcher("/errors/loginFailure.jsp?err=login").forward(req, resp);

            }
        }
        if (r.equals("registration")) {
            String group = req.getParameter("group");
            checkGroup = registration(username, password, group);
            if (checkGroup) {
                getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
                System.out.println("Ricevuta registrazione da Username: " + username + " Password: " + password);
            } else {
                getServletContext().getRequestDispatcher("/errors/loginFailure.jsp?err=registration").forward(req, resp);

            }
        }

    }

    public boolean registration(String username, String password, String group) {
        boolean check = false;
        //controllo che il gruppo sia tra quelli disponibili
        if (group.equals("g0") || group.equals("g1") || group.equals("g2") || group.equals("g0")) {
            d.getUsers().put(username, password);
            d.getSessions().put(username, Optional.empty());
            d.getGroups().put(username, group);
            System.out.println("Registrato utente: " + username + ", gruppo: " + group);
            check = true;
        }
        return check;
    }

    public boolean checkLogin(String username, String password, HttpSession s) {
        boolean check = false;
        //controllo che nome e password corrispondano
        if (d.getUsers().containsKey(username) && d.getUsers().get(username).equals(password)) {
            //controllo che non ci sia la sessione per quell'utente
            if(s.isNew()){
                check=true;
            }else if (d.getSessions().get(username).isEmpty()) {
                System.out.println("Loggato utente: " + username);
                d.getSessions().put(username, Optional.of(s));
                check = true;
            }
        }
        return check;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


    }
}
