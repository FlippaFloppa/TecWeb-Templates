package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utente;

public class Registra extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);

    }

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, NumberFormatException {
		
		String u=req.getParameter("username");
		String p=req.getParameter("password");
		
		ServletContext application = getServletContext();
		if (application.getAttribute("utenti")==null) {
			System.out.println("Errore utenti non presenti");
		}
				
		List<Utente> utenti = (List<Utente>)application.getAttribute("utenti");
		
		boolean b=true;
		
		for (Utente utente : utenti) {
			if (utente.getUsername().equals(u)) {
				b=false;
			}
		}
		
		if(u.equals("ad")) b=false;
		
		//se utente non esistente aggiungo
		if (b) {
			Utente ut=new Utente();
			ut.setUsername(u);
			ut.setPassword(p);
			ut.setSession(req.getSession());
			utenti.add(ut);
			application.setAttribute("utenti", utenti);
			
			resp.sendRedirect(req.getContextPath()+"/login.html");
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/registra.html");
		}
		
	}

	
}
