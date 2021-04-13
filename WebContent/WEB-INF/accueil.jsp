<%@ include file="includes/entete.jsp" %>	
	<span>ENI-Ench�res</span>
	
	<C:choose>
		<C:when test="${empty sessionScope.User}">
			<a style="float:right" href="${pageContext.request.contextPath}/PageConnexion">S'inscrire - Se connecter</a>
		</C:when>
		<C:otherwise>
			<span style="float:right">
				Ench�res 
				Vendre un article 
				<a href="${pageContext.request.contextPath}/monProfil">Mon Profil</a>
				<a href="${pageContext.request.contextPath}/Deconnexion">D�connexion</a>
			</span>
		</C:otherwise>
	</C:choose>
	
	<div style="text-align:center;color:red;font-weight:bold">Liste des ench�res</div>
	
	<br><br><br>
	
	<div class="container-fluid">Filtres : <input type="text"></div><br>
	
	<div class="container-fluid">Cat�gorie : 
	  <select name="categorie">
	  	<option>Informatique</option>
	  	<option>Ameublement</option>
	  	<option>V�tement</option>
	  	<option>Sport&Loisirs</option>
	  </select>
	</div><br>
	
	<input type="button" value="Rechercher">
	
	</body>
</html>