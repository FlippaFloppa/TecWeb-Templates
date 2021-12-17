<%@ page session="true"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carrello</title>
    <h3>Login avvenuto con successo!</h3>

</head>
<body>
<%
    System.out.println(request.getCookies()[0]);
%>
</body>
</html>
