<%@ include file="includes/entete.jsp" %>

	<div>ENI-Enchères</div>
	
	<div style="text-align:center;color:red;font-weight:bold">Profil</div>
	
	<br><br><br>
	
	<C:if test="${!empty requestScope.erreur}">
		<div class="alert alert-danger">${requestScope.erreur}</div>
	</C:if>
	
	<form method="post" action="${pageContext.request.contextPath}/CreationCompte">
		<div class="container-fluid">
			<span>Pseudo : <input type="text" name="pseudo"></span>
			<span style="float:right">Nom : <input type="text" name="nom"></span>
		</div><br>
		<div class="container-fluid">
			<span>Prénom : <input type="text" name="prenom"></span>
			<span style="float:right">Email : <input type="text" name="email"></span>
		</div><br>
		<div class="container-fluid">
			<span>Téléphone : <input type="text" name="tel"></span>
			<span style="float:right">Rue : <input type="text" name="rue"></span>
		</div><br>
		<div class="container-fluid">
			<span>Code postal : <input type="text" name="cp"></span>
			<span style="float:right">Ville : <input type="text" name="ville"></span>
		</div><br>
		<div class="container-fluid">
			<span>Mot de passe : <input type="password" name="mdp"></span>
			<span style="float:right">Confirmation : <input type="password" name="confirmation"></span>
		</div><br>
		
		<div class="container-fluid"><input type="submit" style="margin-left:48%" value="Créer"></div><br>
	</form>
	
	<div class="container-fluid" style="text-align:center"><a href="${pageContext.request.contextPath}/">Annuler</a></div><br>

	</body>
</html>