<%@ include file="includes/entete.jsp" %>

	<div>ENI-Enchères</div>
	
	<div style="text-align:center;color:red;font-weight:bold">Détails vente</div>
	
	<br><br><br>
	<C:forEach var="element" items="${requestScope.Article}">

		<div class="container-fluid"><span id="titre"></span></div><br>
		<div class="container-fluid">Description : ${element.description}</div><br>
		<div class="container-fluid">Catégorie : <span id="categorie"></span></div><br>
		<div class="container-fluid">Meilleure offre : <span id="meilleure"></span></div><br>
		<div class="container-fluid">Fin de l'enchère : <span id="fin"></span></div><br>
		<div class="container-fluid">Retrait : <span id="retrait"></span></div><br>
		<div class="container-fluid">Vendeur : <span id="vendeur"></span></div><br>
		<div class="container-fluid">Proposition : <span id="proposition"></span></div><br>
		<div class="container-fluid"><input type="button" value="Enchérir"></div><br>
		</C:forEach>
</body>
</html>