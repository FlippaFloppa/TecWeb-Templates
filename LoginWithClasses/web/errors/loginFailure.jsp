<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Errore!</title>
</head>
<body>
    <%
        String error = request.getParameter("err");
        String user = request.getParameter("user");
        if (error.equals("user")) {
            out.print("<h2>Errore, username errato!</h2>");
        }
        if (error.equals("pass")) {
            out.print("<h2>Errore, password errata!</h2>");
        }
        if (error.equals("registration")) {
            out.print("<h2>Errore, registrazione non valida</h2>");
        }
        if (error.equals("expired")) {
            out.print("<h2>Errore, password scaduta!!</h2>");
            out.print("<h3>Prima di poter effettuare il login devi cambiare la password!</h2>");
            %>
        <form action="Login?req=reset&username=<%=user%>" method="post">
            <input type="text" name="password"/>
            <br>
            <input type="submit" value="Change Pass">
        </form>
    <%
        }
    %>
<a href="<%= request.getContextPath() %>/login.jsp">Torna alla pagina di Login</a>
</body>
</html>