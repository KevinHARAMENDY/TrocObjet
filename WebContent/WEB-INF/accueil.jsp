<%@ include file="includes/entete.jsp" %>	
	<span>ENI-Enchères</span>
	
	<C:choose>
		<C:when test="${empty sessionScope.User}">
			<a style="float:right" href="${pageContext.request.contextPath}/PageConnexion">S'inscrire - Se connecter</a>
		</C:when>
		<C:otherwise>
			<span style="float:right">
				Enchères 
				Vendre un article 
				<a href="${pageContext.request.contextPath}/monProfil">Mon Profil</a>
				<a href="${pageContext.request.contextPath}/Deconnexion">Déconnexion</a>
			</span>
		</C:otherwise>
	</C:choose>
	
	<div style="text-align:center;color:red;font-weight:bold">Liste des enchères</div>
	
	<br><br><br>
	
	<div class="container-fluid">Filtres : <input type="text"></div><br>
	
	<div class="container-fluid">Catégorie : 
	  <select name="categorie">
	  	<option>Informatique</option>
	  	<option>Ameublement</option>
	  	<option>Vêtement</option>
	  	<option>Sport&Loisirs</option>
	  </select>
	</div><br>
	
	<input type="button" value="Rechercher">
	
	</body>
</html>