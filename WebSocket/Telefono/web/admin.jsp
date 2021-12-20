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
    //non si dovrebbe fare perché le password vengono passate in chiaro. Si dovrebbe interrogare un database con una query e fare l'encoding dei dati
    String username = "";
    String password = "";
    username = request.getParameter("username");
    password = request.getParameter("password");
    if (username.equals("admin") && password.equals("admin")) {
        out.println("<h2>Test</h2>");
    }
%>
</body>
</html>
