<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ page import="it.Test" %>
<%@ page import="java.util.*" %>
<%@ page import="bean.Prenotazione" %>
<%
    if(session.getAttribute("logged")==null ||
        session.getAttribute("logged").equals(false))
    response.sendRedirect(request.getContextPath()+"/login.jsp");
%>
<html>
<head>
    <title>Start Web Application</title>
    <link type="text/css" href="styles/default.css" rel="stylesheet">
    <script type="text/javascript" src="scripts/utils.js"></script>
    <script type="text/javascript" src="scripts/scripts.js"></script>
</head>
<body>

<div id="result">
    <h2>Prenotazioni pendenti:</h2>
<%
    out.print(getServletConfig().getServletContext().getAttribute("pending"));
%>
</div>
</body>
</html>

