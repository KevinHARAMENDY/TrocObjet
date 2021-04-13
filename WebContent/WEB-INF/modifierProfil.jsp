<%@ include file="includes/entete.jsp"%>

<div class="container-fluid">
	<div class ="text-center">
		<h1>Modifier mon profil</h1>
	</div>
	
	<C:if test="${!empty requestScope.erreur}">
		<div class="alert alert-danger">${requestScope.erreur}</div>
	</C:if>
	
	<C:if test="${!empty requestScope.succes}">
		<div class="alert alert-success">${requestScope.succes}</div>
	</C:if>
	
	<form method="post" action="${pageContext.request.contextPath}/modifierProfil">
		<div class="form-group row">
			<label for="pseudo" class="col-sm-2 col-form-label">Pseudo</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="pseudo" name="pseudo"
					value="${User.pseudo}">
			</div>
		</div>
		<div class="form-group row">
			<label for="nom" class="col-sm-2 col-form-label">Nom</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="nom" name="nom" value="${User.nom}">
			</div>
		</div>
		<div class="form-group row">
			<label for="prenom" class="col-sm-2 col-form-label">Prénom</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="prenom" name="prenom"
					value="${User.prenom}">
			</div>
		</div>
		<div class="form-group row">
			<label for="email" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="email" name="email"
					value="${User.email}">
			</div>
		</div>
		<div class="form-group row">
			<label for="telephone" class="col-sm-2 col-form-label">Téléphone</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="telephone" name="telephone"
					value="${User.tel}">
			</div>
		</div>
		<div class="form-group row">
			<label for="rue" class="col-sm-2 col-form-label">Rue</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="rue" name="rue" value="${User.rue}">
			</div>
		</div>
		<div class="form-group row">
			<label for="cp" class="col-sm-2 col-form-label">Code postal</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="cp" name="cp"
					value="${User.code_postal}">
			</div>
		</div>
		<div class="form-group row">
			<label for="ville" class="col-sm-2 col-form-label">Ville</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="ville" name="ville"
					value="${User.ville}">
			</div>
		</div>
		<div class="form-group row">
			<label for="passwordActuel" class="col-sm-2 col-form-label">Mot de passe actuel</label>
			<div class="col-sm-3">
				<input type="password" class="form-control" id="passwordActuel" name="passwordActuel">
			</div>
		</div>
		<div class="form-group row">
			<label for="newPassword" class="col-sm-2 col-form-label">Nouveau mot de passe</label>
			<div class="col-sm-3">
				<input type="password" class="form-control" id="newPassword" name="newPassword">
			</div>
		</div>
		<div class="form-group row">
			<label for="confirmationPassword" class="col-sm-2 col-form-label">Confirmation</label>
			<div class="col-sm-3">
				<input type="password" class="form-control" id="confirmationPassword" name="confirmationPassword">
			</div>
		</div>
		<div class="form-group row">
			<label for="staticCredit" class="col-sm-2 col-form-label">Crédit</label>
			<div class="col-sm-3">
				<input type="text" readonly class="form-control-plaintext"
					id="staticCredit" value="${User.credit}">
			</div>
		</div>
		
		<button class="btn btn-primary" type="submit">Valider</button>
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/supprimerProfil" role="button" onclick="return confirm('Confirmer la suppression du compte ?')">supprimerProfil</a>
	
	</form>

</div>

</body>
</html>