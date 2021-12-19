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
        out.println("<h2>Sessioni attive: " + "admin" + "</h2>");
        out.println("Richieste: " + getServletConfig().getServletContext().getAttribute("counter"));

        List<HttpSession> l = (List<HttpSession>) (getServletConfig().getServletContext().getAttribute("sessions"));
        for (HttpSession httpSession : l) {
            out.println("Sessione: " + httpSession.getId());
        }
        if (l.size() > 1) { %>
<br>
<form action="Test?req=admin" method="post">
    <button name="clear" value="clear">Clear Sessions</button>
</form>
<%}
    } else {
        out.println("<h2>" + "Errore" + "</h2>");
    }
%>
</body>
</html>
