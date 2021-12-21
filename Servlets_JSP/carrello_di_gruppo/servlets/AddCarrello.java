package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utente;

public class AddCarrello extends HttpServlet{

	private static final long serialVersionUID = 1L;
	

	@Override
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
        
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, NumberFormatException {
		
		if (req.getParameter("termina")!=null) {
			if (req.getSession().getAttribute("username")==null) {
				System.out.println("non trovo username nella sessione");
			}else
			{
				String user=(String)req.getSession().getAttribute("username");
				System.out.println("completo acquisto");
				
				ServletContext application = getServletContext();
				List<Utente> utenti = (List<Utente>)application.getAttribute("utenti");
				
				//stampo prodotti carrello
				List<String> prodotti=(List<String>)req.getSession().getAttribute("prodotti");
				for(String s:prodotti) {
					System.out.println(s);
				}
				
				String gruppo="";
				for(Utente u:utenti) {
					if (u.getUsername().equals(user)) {
						u.setTerminato(true);
						gruppo=u.getGroup();
					}
				}
				System.out.println(gruppo);
				int utentiGruppo=0;
				for(Utente u:utenti) {
					if (u.getGroup().equals(gruppo)) {
						utentiGruppo++;
					}
				}
				
				int terminati=0;
				while(terminati!=utentiGruppo) {
					terminati=0;
					for(Utente u:utenti) {
						if (u.getGroup().equals(gruppo)) {
							if(u.isTerminato()==true) {
								terminati++;
							}
						}
					}
				}
				
				System.out.println("terminazione");
				
				resp.sendRedirect(req.getContextPath()+"/404.html");
				
			}
			
		}
		
		else {
			String p=req.getParameter("prodotto");
			System.out.println("aggiungo "+p);
			
			 List<String> prodotti;
	        
	        if (req.getSession().getAttribute("prodotti")==null) {
	        	prodotti=new ArrayList<>();
	        	prodotti.add(p);
	        	req.getSession().setAttribute("prodotti", prodotti);
	        	req.getSession().setMaxInactiveInterval(10);
	        }
	        else {
	        	prodotti=(List<String>)req.getSession().getAttribute("prodotti");
	        	prodotti.add(p);
	        	req.getSession().setAttribute("prodotti", prodotti);
	        }
	        
	        resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}
		
	}

	
}