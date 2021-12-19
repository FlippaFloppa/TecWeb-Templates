<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ page import="it.Test" %>
<%@ page import="java.util.*" %>

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
<div>
    <h2>Scegli il numero di campo</h2>
    <br>
    <select name="campi" id="campi">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
    </select>
</div>
<div>
    <h2>Scegli il tipo di campo</h2>
    <br>
    <select name="scelta" id="scelta">
        <option value="singolare">singolare</option>
        <option value="doppio">doppio</option>
    </select>
</div>
<div>
    <h2>Inserisci data:</h2><input type="text" id="data">
    <h2>Inserisci orario:</h2><input type="text" id="orario">
</div>

<br>
<button id="txt" onclick="calculate()">Submit</button>
<div id="result">
<h3>Response:</h3>
</div>
<a href="<%=request.getContextPath()%>/pending.jsp">Vai a pending</a>

</body>
</html>

