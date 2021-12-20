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

        for(String g:d.getGroups().keySet()){
            checkExpiredPasswords(g);
        }

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
                        getServletContext().getRequestDispatcher("/admin.jsp").forward(req, resp);
                        System.out.println("Amministratore loggato!");
                    }
                    else{
                        getServletContext().getRequestDispatcher("/applicazione.jsp").forward(req, resp);
                        System.out.println("Ricevuto login da Username: " + username + " Password: " + password);
                    }
                }
            }else {
                getServletContext().getRequestDispatcher("/errors/loginFailure.jsp?err=user").forward(req, resp);
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

        if(r.equals("reset")){
            d.getUsers().get(username).setPassword(password);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    private boolean registration(String username, String password, String group) {
        //controllo che il gruppo sia tra quelli disponibili
        if (d.getGroups().containsKey(group) && !d.getUsers().containsKey(username)) {
            d.getUsers().put(username, new Utente(username,password,group));
            d.getGroups().get(group).add(d.getUsers().get(username));
            System.out.println("Registrato utente: " + username + ", gruppo: " + group);
            return true;
        }
        return false;
    }


    private void checkExpiredPasswords(String group){

        int expCounter=0;

        for(Utente u: d.getGroups().get(group)){
            u.checkPasswordAge();
            if(u.isExpired()){
                u.resetPassword();
                expCounter++;
            }
        }

        if(expCounter>2)resetAll(group);
    }

    private void resetAll(String group){
        for(Utente u: d.getGroups().get(group)){
            u.resetPassword();
        }
    }
}
