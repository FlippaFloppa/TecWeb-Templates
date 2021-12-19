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
<div style="float: right;border-width: 2px">
    <a href="admin.jsp"><h2>Vai alla pagina admin</h2></a>
</div>
<div id="result">

</div>

<button name="1" id="1" onclick="calculate('1')">1 Thread</button>
<button name="2" id="2" onclick="calculate('2')">2 Thread</button>
<button name="3" id="3" onclick="calculate('3')">3 Thread</button>
</button>


</body>
</html>

