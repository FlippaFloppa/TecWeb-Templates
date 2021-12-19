package it;

import bean.Attrazione;
import bean.Turista;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Test extends HttpServlet {

    private List<HttpSession> sessions;
    private List<HttpSession> invalidateSessions;

    private static final long serialVersionUID = 1L;
    private int counterReq;

    @Override
    public void init(ServletConfig conf) throws ServletException
    {
        super.init(conf);
        counterReq=0;
        sessions=new ArrayList<>();
        invalidateSessions=new ArrayList<>();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String request=req.getParameter("req");
    if(request.equals("admin")){
        for (HttpSession session : sessions) {
            session.invalidate();
            invalidateSessions.add(session);
        }
        sessions.clear();
        }
        getServletContext().getRequestDispatcher("/admin.jsp?username=admin&password=admin").forward(req, resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        counterReq++;
        HttpSession actualSession=request.getSession();
        System.out.println("Ricevuta sessione: "+actualSession);
        System.out.println("Richieste attuali: "+counterReq);

        if(!sessions.contains(actualSession)){
            sessions.add(actualSession);
        }

        getServletContext().setAttribute("counter",counterReq);
        getServletContext().setAttribute("sessions",sessions);

        String matrix1=request.getParameter("first");
        String matrix2=request.getParameter("second");
        String req=request.getParameter("request");

        String split1[]=matrix1.split("-");
        String split2[]=matrix2.split("-");

        Integer riga1[] = new Integer[split1.length];
        Integer riga2[] = new Integer[split2.length];

        String res1="";
        String res2="";

        System.out.println("Ricevute matrici: "+res1 + "e "+res2);
        System.out.println("Richiesta "+req);

        for (int i = 0; i < split1.length; i++) {
            riga1[i]=Integer.parseInt(split1[i]);
            res1+=riga1[i]+" ";
        }
        for (int y = 0; y < split2.length; y++) {
            riga2[y]=Integer.parseInt(split1[y]);
            res2+=riga2[y]+" ";
        }
        if(req.equals("m")){
            MultiThreadMatrix t1=new MultiThreadMatrix(riga1);
            t1.start();
            int result1=t1.calcolaRes();
            System.out.println("Matrice 1: "+result1);

            MultiThreadMatrix t2=new MultiThreadMatrix(riga1);
            t2.start();
            int result2=t2.calcolaRes();
            System.out.println("Matrice 2: "+result2);

            MultiThreadMatrix t3=new MultiThreadMatrix(riga1);
            t3.start();
            int result3=t3.calcolaRes();
            System.out.println("Matrice 3: "+result3);

            MultiThreadMatrix t4=new MultiThreadMatrix(riga1);
            t4.start();
            int result4=t4.calcolaRes();
            System.out.println("Matrice 4: "+result4);
            response.getWriter().println("<h3>"+result1+"</h3>");
        }

        if(req.equals("s")){
            StringJoiner sj=new StringJoiner(" ");
            for (int i = 0; i < riga1.length ; i++) {
                for (int y = 0; y < riga2.length ; y++) {
                    int tmp=riga1[i]+riga2[y];
                sj.add(""+tmp);
                }
            }
            response.getWriter().println("<h3>"+sj+"<h3>");
        }


    }
}
