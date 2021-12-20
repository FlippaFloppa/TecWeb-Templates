<%@ page session="true"%>
<%@ page import="java.util.*"%>

<html>
<head>
    <title>Start Web Application</title>
    <link type="text/css" href="styles/default.css" rel="stylesheet"></link>
    <meta http-equiv="refresh" content="2;url=<%=request.getContextPath()%>/login.jsp">
</head>
<body>
<!--
 ...so we offer the user something to read, meanwhile.

This is the first page being shown, while the JSF Servlet starts up the environment,
upon the first reqeust.
This message avoid letting the user linger without knowing what's going on.
-->
<p>
    Please wait for the web application to start... &nbsp;
    <img src="images/wait.gif"/>
    <img alt="wait" title="wait" src="images/michele.png" style="width:100%;height:100%"/>
</p>

<a href="<%=request.getContextPath()%>/login.jsp">Login</a>


</body>
</html>

