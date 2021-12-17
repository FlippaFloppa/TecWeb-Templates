<%@ page session="true" %>
<%@ page import="it.Test" %>
<%@ page import="java.util.*" %>
<script type="text/javascript" src="scripts/matrixCalculator.js"></script>
<script type="text/javascript" src="scripts/utils.js"></script>

<html>
<head>
    <title>Start Web Application</title>
    <link type="text/css" href="styles/default.css" rel="stylesheet"></link>
</head>
<body>

<%
    if (request.getSession(false) == null) {
        response.sendRedirect(request.getContextPath() + "/error.jsp");
    }
%>

<div style="float: left;border-width: 2px">
    <h3>Inserisci le matrici:</h3>
    X:<input id="first" type="text" name="testo" size="2" onchange="show()"/>
    Y:<input id="second" type="text" name="testo" size="2" onchange="show()"/>
    <p id="pulsanti">

    </p>
    <h3>Risultato matrici:</h3>
    <p id="single">

    </p>
    <p id="multi">

    </p>

</div>

<div style="float: right;border-width: 2px">
    <h2>Vai alla pagina admin</h2>
    <form name="register" method="post" action=<%=request.getContextPath()%>/admin.jsp>
        Username: <input type="text" name="username"/>
        <br>
        Password: <input type="password" name="password"/>
        <br>
        <input type="submit" value="admin"/>
    </form>

</div>

</body>
</html>

