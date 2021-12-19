<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true"%>
<%@ page import="it.Test"%>
<%@ page import="java.util.*"%>

<html>
<head>
    <title>Admin Page</title>

</head>
<body>
<%
    List<HttpSession> s= (List<HttpSession>)getServletConfig().getServletContext().getAttribute("sessioni");
    StringJoiner sj=new StringJoiner(" ");
    for (HttpSession session1 : s) {
        sj.add("Sessione: "+session1.toString()+"= "+session1.getId()+"\n");
    }
        out.println("<h2>Sessioni attive: "+sj+" </h2>");
%>
</body>
</html>
