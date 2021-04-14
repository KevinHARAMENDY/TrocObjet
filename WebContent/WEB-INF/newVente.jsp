<%@ include file="includes/entete.jsp" %>

		<C:choose>
			<C:when test="${empty sessionScope.User}">
				<a style="float:right" href="${pageContext.request.contextPath}/PageConnexion">S'inscrire - Se connecter</a>
			</C:when>
			<C:otherwise>
				<span style="float:right">
					<a href="${pageContext.request.contextPath}/">Enchères</a>
					<a href="${pageContext.request.contextPath}/NewVente">Vendre un article</a>
					<a href="${pageContext.request.contextPath}/Deconnexion">Déconnexion</a>
		
					<%-- 			<a class="btn" href="${pageContext.request.contextPath}/monProfil" title="MonProfil">Mon Profil</a> --%>
				</span>
			</C:otherwise>
		</C:choose>
	<div>ENI-Enchères</div>
	
	<div style="text-align:center;color:red;font-weight:bold">Nouvelle vente</div>
	
	<br><br><br>
	
	<form action="/TrocObjet/NewVente" method="post" class="form-example">
		<div class="container-fluid">Article : <input type="text" name="article"></div><br>
		<div class="container-fluid">Description : <textarea name="description"></textarea></div><br>
		
		<div class="container-fluid">Catégorie : 
		  <select name="categorie">
			<C:forEach var="element" items="${Categories}">
				<option value="${element.noCategorie }">${element.libelle}</option>
			</C:forEach>
		  </select>
		</div><br>
			
		<div class="container-fluid">Photo de l'article : <input type="file" name="photo" /></div><br>
		<div class="container-fluid">Mise à prix : <input type="number" name="prix" /></div><br>
		<div class="container-fluid">Début de l'enchère : <input type="date" name="debut" /></div><br>
		<div class="container-fluid">Fin de l'enchère : <input type="date" name="fin" /></div><br>
	
		<br><br>
		<div class="container-fluid" style="font-weight:bold">Retrait</div><br>
		<div class="container-fluid">Rue : <input type="text" name="rue" value="${rue}" /></div><br>
		<div class="container-fluid">Code postal : <input type="text" name="cp" value="${cp}" /></div><br>
		<div class="container-fluid">Ville : <input type="text" name="ville" value="${ville}" /></div><br>
	
		<div class="container-fluid"><input type="submit" style="margin-left:47%" value="Enregistrer"></div><br>
	</form>
		<div class="container-fluid"><a href="/TrocObjet/Accueil" style="margin-left:48%">Annuler</a></div><br>
	</body>
</html>