package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utente;

public class Login extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	//private static List<String> gruppi;
	
	@Override
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
        List<Utente> utenti=new ArrayList<>();
        
        //Login.gruppi=Arrays.asList(new String[]{"group1", "group2", "group3"});

        
        /*Utente ad=new Utente();
        ad.setUsername("ad");
        ad.setPassword("ad");
        utenti.add(ad);*/
        
        //inserisco gli utenti già presenti
        Utente a=new Utente();
        a.setUsername("a");
        a.setPassword("a");
        utenti.add(a);
        
        Utente b=new Utente();
        b.setUsername("b");
        b.setPassword("b");
        utenti.add(b);
        
        Utente c=new Utente();
        c.setUsername("c");
        c.setPassword("c");
        utenti.add(c);
        
        Utente d=new Utente();
        d.setUsername("d");
        d.setPassword("d");
        utenti.add(d);
        
        Utente e=new Utente();
        e.setUsername("e");
        e.setPassword("e");
        utenti.add(e);
        
        Utente f=new Utente();
        f.setUsername("f");
        f.setPassword("f");
        utenti.add(f);
               
        //inserisco gli utente nel context application
        ServletContext application = getServletContext();
        application.setAttribute("utenti", utenti);
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, NumberFormatException {
	
		String u=req.getParameter("username");
		String p=req.getParameter("password");
		//String g=req.getParameter("group");
		//System.out.println(""+u+" "+p+" "+g);
		
		
		//admin
		if (u.equals("ad") && p.equals("ad")) {
			req.getSession().setAttribute("admin", true);
			resp.sendRedirect(req.getContextPath()+"/admin.jsp");
		}
		else{

			ServletContext application = getServletContext();
			if (application.getAttribute("utenti")==null) {
				System.out.println("Errore utenti non presenti");
			}

			List<Utente> utenti = (List<Utente>)application.getAttribute("utenti");


			for (int i=0; i<utenti.size(); i++) {
				System.out.println("Utente: "+utenti.get(i).getUsername()+" "+utenti.get(i).getPassword());
				if (utenti.get(i).getUsername().equals(u) && utenti.get(i).getPassword().equals(p) /*&& Login.gruppi.contains(g)*/) {

					//setto il gruppo
					//utenti.get(i).setGroup(g);

					//setto la sessione
					utenti.get(i).setSession(req.getSession());
					req.getSession().setAttribute("username", utenti.get(i).getUsername());
					req.getSession().setAttribute("logged", true);

					application.setAttribute("utenti", utenti);
				}			
			}
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}
	}

	
}
