<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true"%>
<%@ page import="it.Test"%>
<%@ page import="java.util.*"%>
<%@ page import="bean.Albergo" %>
<script type="text/javascript" src="scripts/utils.js"></script>
<script type="text/javascript" src="scripts/functions.js"></script>


<html>
<head>
    <title>Start Web Application</title>
    <link type="text/css" href="styles/default.css" rel="stylesheet"></link>
</head>
<body>
<%
    List<Albergo>l=(List<Albergo>) (getServletConfig().getServletContext().getAttribute("alberghi"));
%>
<div>
    <h2>Inserisci date:</h2>
    <input type="text" id="checkin" name="checkin">
    <br>
    <input type="text" id="checkout" name="checkout" onchange="calculate('calculate')">

    <br>
</div>

<div>
<select name="lista" id="lista">
    <%for (Albergo albergo : l) {
        if(albergo.getId()<Test.n)  {
            out.print("Errore");
        }
    %>
    <option id="a" value="<%=albergo.getId()%>"><%=albergo.toString()%></option>
    <%}%>
</select>

</div>
<div id="tmp">
    <h2>Preventivo:</h2>
</div>
<div id="result">
    <h2>Risultato:</h2>
</div>
<button type="submit" id="button" onClick="calculate('finalize')">Finalizza</button>
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

