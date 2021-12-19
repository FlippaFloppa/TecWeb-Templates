package it;

import bean.Albergo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String path="/Users/patrickdifazio/OneDrive - Alma Mater Studiorum Università di Bologna/Università/Terzo Anno/Tecnologie Web T/Esami/Appello_17sett2019(1)-Alberghi/src/it/albergo.txt";
    private static List<Albergo> listaAlberghi;
    public static final int n=10;
    private int array[];
    private int camere[];
    private int counter;
    @Override
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
        BufferedReader buff = null;
        String line = "";
        listaAlberghi=new ArrayList<>();
        array=new int[8];
        camere=new int[8];
        counter=0;
        try {
            buff = new BufferedReader(new FileReader(path));
            while ((line = (buff.readLine())) != null) {
                String splitter[]=line.split(" ");
                Integer id=Integer.parseInt(splitter[0]);
                Integer camere=Integer.parseInt(splitter[1]);
                Integer prezzo=Integer.parseInt(splitter[2]);
                Albergo a = new Albergo(id,camere,prezzo);
                listaAlberghi.add(a);
                System.out.println(a);
            }
            for(int i=0;i<listaAlberghi.size()-1;i++){
                camere[i]=listaAlberghi.get(i).getCamere()-1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        getServletContext().setAttribute("alberghi",listaAlberghi);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String r=request.getParameter("elem");
        String finalize=request.getParameter("finalize");
        int in=Integer.parseInt(request.getParameter("checkin"));
        int out=Integer.parseInt(request.getParameter("checkout"));
        int id=Integer.parseInt(r);
        int def=listaAlberghi.get(id).getPrezzo();
        array[id]++;
        System.out.println("Richieste: " + array[id] + " per id: " + id);
        int prezzo = (int) (0.1 * array[id] * def * (out - in));
        getServletContext().setAttribute("counter",counter);

        if(finalize.equals("true")) {
            counter++;
            camere[id]--;
            response.getWriter().println("<h3>Prezzo finale per l'albergo selezionato: "+prezzo+" Camere disponibili: "+camere[id]+"</h3>");
        }else {
            response.getWriter().println("<h3>Preventivo per l'albergo selezionato: " + prezzo + " Camere disponibili: " + camere[id] + "</h3>");
        }
    }
}
