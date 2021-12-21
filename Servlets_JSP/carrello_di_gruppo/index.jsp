<%@ page session="true"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="beans.*"%>
<html>
   <head>
      <title>Start Web Application</title>
		<link type="text/css" href="styles/default.css" rel="stylesheet"></link>
		<script type="text/javascript" src="scripts/utils.js"></script>
    	<script type="text/javascript" src="scripts/callback.js"></script>
    	<script type="text/javascript" src="scripts/function.js"></script>
   </head>
   <body>

	<%
   	if(session.getAttribute("logged")==null || session.getAttribute("logged").equals(false))
    	response.sendRedirect(request.getContextPath()+"/login.html");
   %>

      Benvenuto<br><br>
      
      Vedi gli altri utenti: 
      <form action="http://localhost:8080/TW_Esame_211124_newLogin/index.jsp?mostra=si" method="post">
        <button type="submit">Mostra</button>
	</form>
	
	
	<form action="http://localhost:8080/TW_Esame_211124_newLogin/addCarrello" method="post">
        prodotto:
        <input type="text" id="prodotto" name="prodotto"><br>
        <button type="submit">Login</button>
	</form>
	
	
	<br><br>
	<form action="http://localhost:8080/TW_Esame_211124_newLogin/addCarrello?termina=si" method="post">
        <input type="text" id="termina" name="termina" disabled="yes" value="Clicca il bottone per terminare"><br>
        <button type="submit">Termina</button>
	</form>
      
      
      <% 
      	if (request.getParameter("mostra")!=null){
      		List<Utente> ut=(List<Utente>)(getServletConfig().getServletContext().getAttribute("utenti"));
			
      		for (Utente u: ut){
      	%>
      		<br>
      		Utente <%= u.getUsername() %> - gruppo <%= u.getGroup() %>
      	<%		
      		}
      	}
      %>
      

   </body>
</html>

