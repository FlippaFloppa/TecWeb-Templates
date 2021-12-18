<%@ page import="com.google.gson.Gson" %>
<%@ page import="it.Test" %><%--
  Created by IntelliJ IDEA.
  User: patrickdifazio
  Date: 18/12/21
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index2</title>
</head>
<body>
<%
    char c2='b';
    char c5='e';
    String tmp="";

    Gson g=new Gson();
    String r = request.getParameter("tmp");
    String s = (String)getServletConfig().getServletContext().getAttribute("step1");
    String result=g.fromJson(s,String.class);
    System.out.println("lavoro su: "+result+" "+r);

    if(r.equals("1")) {
        for (int i=0;i<result.length();i++){
            if(result.charAt(i)!=c2){
                tmp+=result.charAt(i);
            }else{
                Test.counter++;
            }
        }
        System.out.println("Invio stringa 2: "+tmp);
        getServletConfig().getServletContext().setAttribute("step3",g.toJson(tmp));
        response.sendRedirect(request.getContextPath()+"/index.jsp?tmp=3");

    }
    if(r.equals("4")) {
        tmp="";
        s = g.fromJson((String)getServletConfig().getServletContext().getAttribute("step4"),String.class);
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)!=c5){
                tmp+=s.charAt(i);
            }else{
                Test.counter++;
            }
        }
        System.out.println("Stampo stringa 5: "+tmp);
        response.getWriter().println(tmp);
    }

%>
</body>
</html>
