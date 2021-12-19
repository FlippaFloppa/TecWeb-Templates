package it;

import bean.Dati;
import bean.Prenotazione;
import com.google.gson.Gson;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private boolean checkLogin = false;
    private Map<String, String> defaultUsers;
    private List<Prenotazione> prenotazioni;
    private Dati d;
    private Gson g;
    private int count2;
    private int count4;

    @Override
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
        //dati con scope application
        d = (Dati) getServletContext().getAttribute("dati");
        defaultUsers = new HashMap<>(d.getUsers());
        prenotazioni = new ArrayList<>();
        g = new Gson();
        count2=0;
        count4=0;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String r = req.getParameter("req");
        String p1 = req.getParameter("p1");
        if (r != null && r.equals("login")) {
            checkLogin = checkLogin(username, password);
            if (checkLogin) {
                req.getSession().setAttribute("logged",true);
                if (username.equals("admin")) {
                    getServletContext().getRequestDispatcher("/admin.jsp?username=admin&password=admin").forward(req, resp);
                }

                getServletContext().getRequestDispatcher("/tennis.jsp").forward(req, resp);
                System.out.println("Ricevuto login da Username: " + username + " Password: " + password);
            } else {

                getServletContext().getRequestDispatcher("/errors/loginFailure.jsp?err=login").forward(req, resp);

            }
        } else if (p1 != null && p1.equals("json")) {
            String oggetto = req.getParameter("p2");
            Prenotazione p = g.fromJson(oggetto, Prenotazione.class);
            boolean res = false;
            if (prenotazioni.isEmpty()) {
                prenotazioni.add(p);
            } else {
                for (Prenotazione prenotazione : prenotazioni) {
                    if (prenotazione.getData() == p.getData() || prenotazione.getOrario() == p.getOrario()) {
                        res = true;
                    }
                }
                if (!res) {
                    if(p.getScelta().equals("singolare")){
                        count2++;
                        if(count2<2){
                            System.out.println("Count: "+count2);
                            prenotazioni.add(p);
                        }else{
                            count2=0;
                            prenotazioni.remove(0);
                            prenotazioni.remove(1);
                            System.out.println("Rimuovo un singolo");
                        }
                    }if(p.getScelta().equals("doppio")) {
                        count4++;
                        if(count4<4){
                            System.out.println("Count: "+count4);
                            prenotazioni.add(p);
                        }else{
                            count4=0;
                            prenotazioni.remove(0);
                            prenotazioni.remove(1);
                            prenotazioni.remove(2);
                            prenotazioni.remove(3);
                            System.out.println("Rimuovo un doppio");

                        }
                    }
                }
            }

            this.getServletContext().setAttribute("pending", prenotazioni);
            resp.getWriter().println("Prenotazione selezionata");
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
