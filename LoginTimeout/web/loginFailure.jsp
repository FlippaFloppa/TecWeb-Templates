<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Errore!</title>
    <%
        String error = request.getParameter("err");
        if (error.equals("login")) {
            out.print("<h2>Errore, login non valido</h2>");
        }
        if (error.equals("registration")) {
            out.print("<h2>Errore, registrazione non valida</h2>");
        }
        if (error.equals("expiration")) {
            out.print("<h2>Errore, devi cambiare password!</h2>");
        }
    %>
</head>
<body>
<a href="<%= request.getContextPath() %>/login.jsp">Torna alla pagina di Login</a>
</body>
</html>