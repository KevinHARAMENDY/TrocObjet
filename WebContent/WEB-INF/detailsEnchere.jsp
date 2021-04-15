<%@ include file="includes/entete.jsp"%>

<div class="container-fluid">
	<div class="text-center">
		<h1>Détail</h1>
	</div>

	<br> <br> <br>

	<div class="row justify-content-md-center">
		<div class="col-5"><h1>${enchere.article.nom_article}</h1></div>
	</div>
	<br>
	<div class="row justify-content-md-center">
		<div class="col-2">Description :</div>
		<div class="col-3">${enchere.article.description}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Catégorie :</div>
		<div class="col-3">${enchere.article.categorie.libelle}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Meilleure offre :</div>
		<div class="col-3">${enchere.article.prix_vente}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Mise à prix :</div>
		<div class="col-3">${enchere.article.prix_initial}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Fin de l'enchère :</div>
		<div class="col-3">${enchere.article.date_fin_encheres}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Retrait :</div>
		<div class="col-3">A faire !!</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Vendeur :</div>
		<div class="col-3">${enchere.utilisateur.pseudo}</div>
	</div>

	<form method="post"	action="${pageContext.request.contextPath}/detailEnchere?idArticle=${enchere.article.noArticle}">
		<div class="row justify-content-md-center form-group">
			<label for="maProposition" class="col-2 col-form-label">Ma Proposition :</label>
			<div class="col-3">
				<input type="number" class="form-control" id="maProposition" name="maProposition" value="${enchere.article.prix_initial }" min="${enchere.article.prix_initial }">
			</div>
		</div>
		<br>
		<div class="row justify-content-md-center">
			<button class="btn btn-primary col-1" type="submit">Enchérir</button>
		</div>
	</form>

</div>
</body>
</html>