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
<div style="float: left;border-width: 2px">

    <form name="loginForm" method="post" action="Login?req=login">
        Username: <input type="text" name="username"/>
        <br>
        Password: <input type="text" name="password"/>
        <br>
        <input type="submit" value="Login" />
    </form>
</div>
<div style="float: right;border-width: 2px">
    <form name="register" method="post" action="Login?req=registration">
        Username: <input type="text" name="username"/>
        <br>
        Password: <input type="text" name="password"/>
        <br>
        Group: <input type="text" name="group"/>
        <br>
        <input type="submit" value="Registration" />
    </form>


</div>
</body>
</html>
