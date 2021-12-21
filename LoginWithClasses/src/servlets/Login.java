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

            if(d.getUsers().containsKey(username)){
                if(d.getUsers().get(username).isExpired()){
                    getServletContext().getRequestDispatcher("/errors/loginFailure.jsp?err=expired&user="+username).forward(req, resp);
                }
                else if(d.getUsers().get(username).getPassword().compareTo(password)!=0){
                    d.getUsers().get(username).incWrongPassword();
                    getServletContext().getRequestDispatcher("/errors/loginFailure.jsp?err=pass").forward(req, resp);
                }
                else{

                    if(username.compareTo("admin")==0){
                        System.out.println("Amministratore loggato!");
                        getServletContext().getRequestDispatcher("/admin.jsp").forward(req, resp);
                    }
                    else{
                        d.getUsers().get(username).setSession(req.getSession());
                        getServletContext().getRequestDispatcher("/app.jsp").forward(req, resp);
                        System.out.println("Ricevuto login da Username: " + username + " Password: " + password);
                    }
                }
            }else {
                getServletContext().getRequestDispatcher("/errors/loginFailure.jsp?err=user").forward(req, resp);
            }

        }
        if (r.equals("registration")) {
            System.out.println("Ricevuta registrazione da Username: " + username + " Password: " + password);

            if (registration(username, password)) {
                getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/errors/loginFailure.jsp?err=registration").forward(req, resp);
            }
        }

        if(r.equals("reset")){
            d.getUsers().get(username).setPassword(password);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    private boolean registration(String username, String password) {
        //controllo che il gruppo sia tra quelli disponibili
        if (!d.getUsers().containsKey(username)) {
            d.getUsers().put(username, new Utente(username,password));
            System.out.println("Registrato utente: " + username);
            return true;
        }
        return false;
    }


}
