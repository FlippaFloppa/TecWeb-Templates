<%@ page import="servlets.ProvaWS_2" %>
<%@ page import="beans.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if (username.equals("admin") && password.equals("admin")) {
    out.print("<h2>Giocatori attuali:</h2>");
    List<User> ListaUtenti=ProvaWS_2.sessioni;
    out.print("<h3>"+ ListaUtenti.toString() +"</h3>");
    }

%>

<body>
</body>
</html>
