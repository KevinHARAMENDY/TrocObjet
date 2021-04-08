<%@ include file="includes/entete.jsp" %>
	<div>ENI-Ench�res</div>
	
	<div style="text-align:center;color:red;font-weight:bold">Connexion</div>
	
	<br><br><br>
	
	<C:if test="${!empty requestScope.erreur}">
		<div class="alert alert-danger">${requestScope.erreur}</div>
	</C:if>
	
	<form method="post" action="${pageContext.request.contextPath}/PageConnexion">
		<div class="container-fluid">Identifiant : <input type="text" name="identifiant"></div><br>
		<div class="container-fluid">Mot de passe : <input type="password" name="mdp"></div><br>
		<div class="container-fluid"><input type="submit" value="Connexion"></div><br>
		<div class="container-fluid"><input type="checkbox" name="souvenir"> Se souvenir de moi</div><br>
	</form>
	
	<div class="container-fluid">Mot de passe oubli�</div><br>
	
	<br><br>
	
	<div class="container-fluid"><a href="${pageContext.request.contextPath}/CreationCompte">Cr�er un compte</a></div><br>

	</body>
</html>