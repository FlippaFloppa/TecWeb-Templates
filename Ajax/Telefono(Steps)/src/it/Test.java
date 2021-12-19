package it;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Test extends HttpServlet {

    private static Gson g;
    private static final long serialVersionUID = 1L;
    private static final char c1='a';
    private static final char c4='d';
    public static int counter=0;

    @Override
    public void init() throws ServletException {
        super.init();
        g=new Gson();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String r=request.getParameter("elem");
        String tmp = "";
        if(r!=null) {
            tmp = "";
            for (int i = 0; i < r.length(); i++) {
                if (r.charAt(i) != c1) {
                    tmp += r.charAt(i);
                }else {
                    counter++;
                }
            }
            System.out.println("Invio stringa 1: " + tmp);
            getServletContext().setAttribute("step1", g.toJson(tmp));
            response.sendRedirect(request.getContextPath() + "/index2.jsp?tmp=1");
        }else{
            r=request.getParameter("tmp");
            if(r!=null&&r.equals("3")){
                String s = g.fromJson((String)getServletConfig().getServletContext().getAttribute("step4"),String.class);
                System.out.println("Stringa 3: " + s);

                tmp = "";
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != c4) {
                        tmp += s.charAt(i);
                    }else {
                        counter++;
                    }
                }
                System.out.println("Invio stringa 4: " + tmp);
                getServletContext().setAttribute("step4", g.toJson(tmp));
                response.sendRedirect(request.getContextPath() + "/index2.jsp?tmp=4");
            }
        }

    }
}
