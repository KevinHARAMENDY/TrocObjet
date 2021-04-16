<%@ include file="includes/entete.jsp" %>
	<div>ENI-Enchères</div>
	
	<div style="text-align:center;color:red;font-weight:bold">Connexion</div>
	
	<br><br><br>
	
	<C:if test="${!empty requestScope.erreur}">
		<div class="alert alert-danger">${requestScope.erreur}</div>
	</C:if>
	
	<form method="post" action="${pageContext.request.contextPath}/PageConnexion">
		<div class="container-fluid">Identifiant : <input type="text" name="identifiant" placeholder="email"></div><br>
		<div class="container-fluid">Mot de passe : <input type="password" name="mdp"></div><br>
		<!-- <div class="container-fluid"><input type="checkbox" name="souvenir"> Se souvenir de moi</div><br> -->
		<div class="container-fluid"><input type="submit" value="Connexion"></div><br>
	</form>
	
	<br><br>
	
	<div class="container-fluid"><a href="${pageContext.request.contextPath}/CreationCompte">Créer un compte</a></div><br>

	</body>
</html>