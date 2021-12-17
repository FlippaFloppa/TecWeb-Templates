<%@ page import="bean.Dati" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="bean.Utente" %><%--
  Created by IntelliJ IDEA.
  User: lollo
  Date: 17/12/2021
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <jsp:useBean id="dati" class="bean.Dati" scope="application"/>

    <title>AMMINISTRATORE</title>

</head>


<body>
    <h1>Pagina Amministratore</h1>
    <%
        for(String g:dati.getGroups().keySet()){
             %>
            <table class="summary-table">
            <caption>
                <%=g%>
            </caption>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Days until expired</th>
                    <th>Expired</th>
                </tr>
             <%
            for(Utente u:dati.getGroups().get(g)){
                %>
                <tr>
                    <td><%=u.getUsername()%></td>
                    <td><%=u.getPassword()%></td>
                    <td><%=u.daysUntilExpired()%></td>
                    <td><%=u.isExpired()%></td>
                </tr>
                <%
            }%>

            </table>
    <br>
    <br>
    <%
        }
    %>
    <a href="<%= request.getContextPath() %>/login.jsp">Torna alla pagina di Login</a>
</body>
</html>
