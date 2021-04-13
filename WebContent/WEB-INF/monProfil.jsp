<%@ include file="includes/entete.jsp"%>

<div class="container-fluid">
	<div style="text-align: center;">
		<h1>profil : ${User.pseudo}</h1>
	</div>

	<br>
	<br>
	<br>
	
	<C:if test="${!empty requestScope.succes}">
		<div class="alert alert-success">${requestScope.succes}</div>
	</C:if>
	
	<div class="row justify-content-md-center">
		<div class="col-2">Pseudo :</div>
		<div class="col-3">${User.pseudo}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Nom :</div>
		<div class="col-3">${User.nom}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Prénom :</div>
		<div class="col-3">${User.prenom}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Email :</div>
		<div class="col-3">${User.email}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Téléphone :</div>
		<div class="col-3">${User.tel}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Rue :</div>
		<div class="col-3">${User.rue}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Code Postal :</div>
		<div class="col-3">${User.code_postal}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Ville :</div>
		<div class="col-3">${User.ville}</div>
	</div>
	<br>
	<div class="row justify-content-md-center">
		<div class="col-2"><a class="btn btn-primary" href="${pageContext.request.contextPath}/modifierProfil" role="button">Modifier</a></div>
	</div>

</div>
</body>
</html>