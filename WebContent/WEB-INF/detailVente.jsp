<%@ include file="includes/entete.jsp" %>

	<div>ENI-Ench�res</div>
	
	<div style="text-align:center;color:red;font-weight:bold">D�tails vente</div>
	
	<br><br><br>
	<C:forEach var="element" items="${requestScope.Article}">

		<div class="container-fluid"><span id="titre"></span></div><br>
		<div class="container-fluid">Description : ${element.description}</div><br>
		<div class="container-fluid">Cat�gorie : <span id="categorie"></span></div><br>
		<div class="container-fluid">Meilleure offre : <span id="meilleure"></span></div><br>
		<div class="container-fluid">Fin de l'ench�re : <span id="fin"></span></div><br>
		<div class="container-fluid">Retrait : <span id="retrait"></span></div><br>
		<div class="container-fluid">Vendeur : <span id="vendeur"></span></div><br>
		<div class="container-fluid">Proposition : <span id="proposition"></span></div><br>
		<div class="container-fluid"><input type="button" value="Ench�rir"></div><br>
		</C:forEach>
</body>
</html>