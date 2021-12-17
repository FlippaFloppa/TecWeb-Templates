package servlets;

import bean.Dati;
import bean.Group;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private boolean checkLogin = false;
    private boolean checkGroup = false;
    private Map<String, Long> validation;
    private Map<String, Group> groupMap;
    private Map<String, String> defaultUsers;
    private Dati d;

    @Override
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
        //dati con scope application
        d = (Dati) getServletContext().getAttribute("dati");
        defaultUsers = new HashMap<>(d.getUsers());
        groupMap = new HashMap<>(d.getGroups());
        validation = new HashMap<>();
        this.getServletContext().setAttribute("sessioni", groupMap);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String r = req.getParameter("req");

        if (r.equals("login")) {
            checkLogin = checkLogin(username, password, req, resp);
            if (checkLogin) {
                if (username.equals("admin")) {
                    getServletContext().getRequestDispatcher("/admin.jsp?username=admin&password=admin").forward(req, resp);
                }

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
                validation.put(username, System.currentTimeMillis() + 30000);
                groupMap.put(username, new Group(group));
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
            d.getGroups().put(username, new Group(group));
            System.out.println("Registrato utente: " + username + ", gruppo: " + group);
            check = true;
        }
        return check;
    }

    public boolean checkLogin(String username, String password, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (defaultUsers.containsKey(username) && d.getUsers().get(username).equals(password)) return true;
        if (validation.get(username) != null) {
            long time = validation.get(username);
            long res = (time - System.currentTimeMillis()) / 1000;
            System.out.println("Secondi rimanenti: " + res);
            if (res <= 0) {
                getServletContext().getRequestDispatcher("/errors/loginFailure.jsp?err=expiration").forward(req, resp);
                return false;
            } else return true;
        }
        return false;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


    }
}
