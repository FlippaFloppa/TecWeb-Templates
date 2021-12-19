<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true"%>
<%@ page import="it.Test"%>
<%@ page import="java.util.*"%>

<html>
<head>
    <title>Admin Page</title>
    <meta http-equiv="refresh" content="5">
</head>
<body>
<%
    //non si dovrebbe fare perché le password vengono passate in chiaro. Si dovrebbe interrogare un database con una query e fare l'encoding dei dati
    String username = "";
    String password = "";
    username = request.getParameter("username");
    password = request.getParameter("password");
    if (username.equals("admin") && password.equals("admin")) {
        out.print("<h2>Prenotazioni Attuali:</h2>");
        out.print(getServletConfig().getServletContext().getAttribute("pending"));
    }
%>
</body>
</html>
