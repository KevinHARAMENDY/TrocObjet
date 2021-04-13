<%@ include file="includes/entete.jsp"%>

<div class="container-fluid">
	<div class ="text-center">
		<h1>profil : ${user.pseudo}</h1>
	</div>

	<br>
	<br>
	<br>
	
	<div class="row justify-content-md-center">
		<div class="col-2">Pseudo :</div>
		<div class="col-3">${user.pseudo}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Nom :</div>
		<div class="col-3">${user.nom}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Prénom :</div>
		<div class="col-3">${user.prenom}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Email :</div>
		<div class="col-3">${user.email}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Téléphone :</div>
		<div class="col-3">${user.tel}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Rue :</div>
		<div class="col-3">${user.rue}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Code Postal :</div>
		<div class="col-3">${user.code_postal}</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-2">Ville :</div>
		<div class="col-3">${user.ville}</div>
	</div><br>
	
	<div style="text-align:center"><a href="${pageContext.request.contextPath}/">Retour à l'accueil</a></div>

</div>
</body>
</html>