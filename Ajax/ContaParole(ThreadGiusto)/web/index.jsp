<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true"%>
<%@ page import="it.Test"%>
<%@ page import="java.util.*"%>

<html>
<head>
    <title>Start Web Application</title>
    <link type="text/css" href="styles/default.css" rel="stylesheet">
    <script type="text/javascript" src="scripts/utils.js"></script>
    <script type="text/javascript" src="scripts/scripts.js"></script>
</head>
<body>
<h2>Inserisci la parola!</h2>
<input type="text" id="parola">
<h2>Scegli quanti Threads</h2>
<button id="1" onclick=calculate('1')>1 Thread</button>
<button id="2" onclick=calculate('2')>2 Thread</button>
<button id="3" onclick=calculate('3')>3 Thread</button>

<div id="result">

</div>
<a href="<%=request.getContextPath()%>/admin.jsp">Vai ad Admin</a>
</body>
</html>

