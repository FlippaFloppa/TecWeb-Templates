<%@ page session="true"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="servlets.Login"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="dati" class="bean.Dati" scope="application"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>

    <form name="loginForm" method="post" action="Login">
        Username: <input type="text" name="username"/> <br/>
        Password: <input type="password" name="password"/> <br/>
        Group: <input type="group" name="group"/> <br/>
        <input type="submit" value="Login" />
    </form>

    <% String name=(String)request.getAttribute("res");
        out.print("Nome: "+name);
        String sessionattribute=(String)request.getSession().getAttribute("something");
        out.print("Sessione: "+sessionattribute);

    %>

</div>
</body>
</html>
