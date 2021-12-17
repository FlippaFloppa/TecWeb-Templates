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

<table class="formdata" style=";width:100%">

    <tr>
        <td style="align-content: center">
    <h1>LOGIN</h1>

    <form name="loginForm" method="post" action="Login?req=login">
        Username: <input type="text" name="username"/>
        <br><br>
        Password: <input type="password" name="password"/>
        <br><br>
        <input type="submit" value="Login" />
    </form>

        </td>
        <td style="align-content: center">

    <h1>SIGN IN</h1>

    <form name="register" method="post" action="Login?req=registration">
        Username: <input type="text" name="username"/>
        <br><br>
        Password: <input type="password" name="password"/>.
        <br><br>
        Group:
        <select name="group">
            <%
            for(String g:dati.getGroups().keySet()){
            %> <option value="<%=g%>"><%=g%></option>
            <%
                }
            %>
        </select>
        <br><br>
        <input type="submit" value="Registration" />
    </form>

        </td>

    </tr>

</table>

</body>
</html>
