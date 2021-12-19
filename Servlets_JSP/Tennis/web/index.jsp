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
<a href=<%=request.getContextPath()%>/login.jsp>vai ad tennis</a>
<input type="text" id="txt" onchange="calculate()">
<div id="result">

</div>
</body>
</html>

