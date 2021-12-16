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

    <h1>LOGIN</h1>

    <form name="loginForm" method="post" action="Login?req=login">
        Username: <input type="text" name="username"/>
        <br>
        Password: <input type="password" name="password"/>
        <br>
        <input type="submit" value="Login" />
    </form>
</div>
<div style="float: right;border-width: 2px">

    <h1>SIGN IN</h1>

    <form name="register" method="post" action="Login?req=registration">
        Username: <input type="text" name="username"/>
        <br>
        Password: <input type="password" name="password"/>.
        <br>
        Group:
        <select name="group">
            <%
            for(String g:dati.getGroups()){
            %> <option value="<%=g%>"><%=g%></option>
            <%
                }
            %>
        </select>
        <br>
        <input type="submit" value="Registration" />
    </form>
</div>

</body>
</html>
