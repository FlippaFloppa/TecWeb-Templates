<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true"%>
<%@ page import="it.Test"%>
<%@ page import="java.util.*"%>

<html>
<head>
    <title>Admin Page</title>

</head>
<body>
<%

        long tempoMedio=0;
        List<Long> tempi=(List<Long>) getServletConfig().getServletContext().getAttribute("tempi");
        for (Long t : tempi) {
            tempoMedio += t;
        }
        long tempoResult=(tempoMedio/tempi.size());
        out.println("<h2>Tempo medio: "+tempoResult+"</h2>");
    out.println("<h2>Lista tempi: "+tempi+"</h2>");

%>
</body>
</html>
