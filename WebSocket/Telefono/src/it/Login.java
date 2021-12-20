package it;

import bean.Dati;
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
    private Map<String, String> defaultUsers;
    private Dati d;


    @Override
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
        d = (Dati) getServletContext().getAttribute("dati");
        defaultUsers = new HashMap<>(d.getUsers());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String r = req.getParameter("req");
        if (r != null && r.equals("login")) {
            checkLogin = checkLogin(username, password);
            if (checkLogin) {
                req.getSession().setAttribute("logged",true);
                if (username.equals("admin")) {
                    getServletContext().getRequestDispatcher("/admin.jsp?username=admin&password=admin").forward(req, resp);
                }

                getServletContext().getRequestDispatcher("/telefono.jsp").forward(req, resp);
                System.out.println("Ricevuto login da Username: " + username + " Password: " + password);
            } else {

                getServletContext().getRequestDispatcher("/errors/loginFailure.jsp?err=login").forward(req, resp);

            }
        }

    }

    public boolean checkLogin(String username, String password) throws ServletException, IOException {
        return defaultUsers.containsKey(username) && d.getUsers().get(username).equals(password);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.getWriter().println(request.getParameter("elem"));

    }
}
