<%@ page session="true"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="servlets.Login"%>
<%@ page import="java.util.*"%>

<jsp:useBean id="dati" class="bean.Dati" scope="application"/>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="styles/login.css">
</head>
<body>
<%
    if(request.getParameter("op")==null || request.getParameter("op").compareTo("reg")!=0){
%>
<div class="login-form">
    <form action="Login?req=login" method="post">
        <h2 class="text-center">Log in</h2>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Username" required="required" name="username">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" placeholder="Password" required="required" name="password">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
    </form>
    <p class="text-center"><a href="?op=reg">Create an Account</a></p>
</div>
<%
}
else
{
%>
<div class="login-form">
    <form action="Login?req=registration" method="post">
        <h2 class="text-center">Sign In</h2>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Username" required="required" name="username">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" placeholder="Password" required="required" name="password">
        </div>
        <div class="form-group">
            <select name="group" class="custom-select">
                <%
                    for(String g:dati.getGroups().keySet()){
                %> <option value="<%=g%>"><%=g%></option>
                <%
                    }
                %>
            </select>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Register</button>
        </div>
    </form>
    <p class="text-center"><a href="?op=log">Log in</a></p>
</div>
<%
    }
%>

</body>
</html>