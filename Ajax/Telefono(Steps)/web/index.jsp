<%@ page session="true"%>
<!-- import di classi Java -->
<%@ page import="it.Test"%>
<%@ page import="java.util.*"%>
<%@ page import="com.google.gson.Gson" %>
<script type="text/javascript" src="scripts/utils.js"></script>
<script type="text/javascript" src="scripts/functions.js"></script>
<html>
<head>
    <title>Start Web Application</title>
    <link type="text/css" href="styles/default.css" rel="stylesheet"></link>
</head>
<body>
<!--
 ...so we offer the user something to read, meanwhile.

This is the first page being shown, while the JSF Servlet starts up the environment,
upon the first reqeust.
This message avoid letting the user linger without knowing what's going on.
-->
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
<p>
    Please wait for the web application to start... &nbsp;
    <img alt="wait" title="wait" src="images/wait.gif"/>
</p>
<%
    Gson g=new Gson();
    String r = request.getParameter("tmp");
    char c3 = 'c';

    if(r!=null && r.equals("3")) {
        String tmp = "";
        String s = (String) getServletConfig().getServletContext().getAttribute("step3");
        String result = g.fromJson(s, String.class);
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != c3) {
                tmp += result.charAt(i);
            }else{
                Test.counter++;
            }
        }
        System.out.println("Invio stringa 3: " + tmp);
        getServletConfig().getServletContext().setAttribute("step4", g.toJson(tmp));
        response.sendRedirect(request.getContextPath() + "/Test?tmp=3");

    }

%>
<div>
    <h3>Inserisci 100 caratteri!: </h3>
    <input type="text" id="txt" size="50" onfocusout="calculate()">

</div>
<div id="result">
    <h3>Risultato: </h3>
</div>
</body>
</html>

