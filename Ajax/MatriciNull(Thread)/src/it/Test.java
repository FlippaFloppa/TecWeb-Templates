package it;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Test extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private List<HttpSession> sessioni;
    private MultiThreadMatrix t1;
    private MultiThreadMatrix t2;
    private MultiThreadMatrix t3;
    private MultiThreadMatrix t4;

    @Override
    public void init() throws ServletException {
        super.init();
        sessioni=new ArrayList<>();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String first="";
        String second="";
        String third="";
        String fourth="";
        boolean res1;boolean res2;boolean res3;boolean res4;

        sessioni.add(request.getSession());
        getServletContext().setAttribute("sessioni",sessioni);
        String p1=request.getParameter("p1");
        String status=request.getParameter("p2");
        switch (status){
            case "1":
                t1=new MultiThreadMatrix(p1);
                t1.start();
                res1 = t1.isEmpty();
                response.getWriter().println("Matrice vuota? --> "+res1+" Tempo impiegato: "+t1.getTime());
                break;
            case "2":
                first=p1.substring(0,p1.length()/2);
                second=p1.substring((p1.length()/2)+1);
                t1=new MultiThreadMatrix(first);
                t1.start();
                res1 = t1.isEmpty();
                t2=new MultiThreadMatrix(second);
                t2.start();
                res2 = t2.isEmpty();
                response.getWriter().println("Matrice vuota? --> "+res1 + "-"+res2+" Tempo impiegato: 1:"+t1.getTime()+" 2: "+t2.getTime());
                break;
            case "3":
                first=p1.substring(p1.length());
                t1=new MultiThreadMatrix(first);
                t1.start();
                res1 = t1.isEmpty();
                t2=new MultiThreadMatrix(first);
                t2.start();
                res2 = t2.isEmpty();
                t3=new MultiThreadMatrix(first);
                t3.start();
                res3 = t3.isEmpty();
                t4=new MultiThreadMatrix(first);
                t4.start();
                res4 = t4.isEmpty();
                response.getWriter().println("Matrice vuota? --> "+res1 + "-"+res2+"-"+res3 + "-"+res4+" Tempo impiegato: 1:"+t1.getTime()+" 2: "+t2.getTime()+" 3: "+t3.getTime()+" 4: "+t4.getTime());
                break;
            default:
                response.getWriter().println("Errore di computazione matrice");
                break;
        }
    return;
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


    }
}
