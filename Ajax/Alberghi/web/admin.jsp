<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<%
    String username = "";
    String password = "";
    username = request.getParameter("username");
    password = request.getParameter("password");
    if (username.equals("admin") && password.equals("admin")) {
        out.println("<h2>Finalizzazioni avvenute: " +getServletConfig().getServletContext().getAttribute("counter")+"</h2>");
    }
%>
</body>
</html>
