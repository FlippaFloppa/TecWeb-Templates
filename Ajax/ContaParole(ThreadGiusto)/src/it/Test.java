package it;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Test extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private int counter;
    private long time1,time2;
    private List<Long> listaTempi=new ArrayList<>();
    private Gson g;
    @Override
    public void init() throws ServletException {
        super.init();
        g=new Gson();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        counter=0;
        time1=System.currentTimeMillis();
        String parola=request.getParameter("p1");
        String payload=request.getParameter("p2");
        System.out.println("Ricevuta parola: "+parola);
        System.out.println("Ricevuto elemento : "+payload);
        String e=g.fromJson(payload,String.class);

        if(e.contains(parola)){
            counter++;
        }
        time2=System.currentTimeMillis();
        long resultTempi=time2-time1;
        listaTempi.add(resultTempi);
        getServletContext().setAttribute("tempi",listaTempi);
        Risultato r=new Risultato(counter,resultTempi);
        String res=g.toJson(r);
        System.out.println(res);
        response.getWriter().println(res);

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


    }
}
