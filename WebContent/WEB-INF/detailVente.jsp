<%@ include file="includes/entete.jsp" %>

	<span>ENI-Ench�res</span>
		
		<C:choose>
			<C:when test="${empty sessionScope.User}">
				<a style="float:right" href="${pageContext.request.contextPath}/PageConnexion">S'inscrire - Se connecter</a>
			</C:when>
			<C:otherwise>
				<span style="float:right">
					<a href="${pageContext.request.contextPath}/">Ench�res</a>
					<a href="${pageContext.request.contextPath}/NewVente">Vendre un article</a>
					<a href="${pageContext.request.contextPath}/Deconnexion">D�connexion</a>
		
					<%-- 			<a class="btn" href="${pageContext.request.contextPath}/monProfil" title="MonProfil">Mon Profil</a> --%>
				</span>
			</C:otherwise>
		</C:choose>
	<div style="text-align:center;color:red;font-weight:bold">D�tails vente</div>
	
	<br><br><br>
	<div class="card" style="width: 22rem;margin: 0 auto;width: 500px;">
			<div class="container-fluid" style="text-align:center;font-weight:bold">${article.nom_article}${art.nom_article}</div><br>
			<div class="container-fluid">Description : ${article.description}${art.description}</div><br>
			<div class="container-fluid">Cat�gorie : ${article.categorie.libelle}${art.categorie.libelle}</div><br>
			<div class="container-fluid">Meilleure offre : ${article.prix_vente}${art.prix_vente}</div><br>
			<div class="container-fluid">Fin de l'ench�re : ${article.date_fin_encheres}${art.date_fin_encheres}</div><br>
			<div class="container-fluid">Retrait : ${retrait.rue}<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${retrait.code_postal}&nbsp;${retrait.ville}</div><br>
			<div class="container-fluid">Vendeur : ${article.utilisateur.pseudo}${art.utilisateur.pseudo}</div><br>
			<div class="container-fluid">Proposition : <span id="proposition"></span></div><br>
			<div class="container-fluid"><input type="button" value="Ench�rir"></div><br>
	</div>
		
</body>
</html>