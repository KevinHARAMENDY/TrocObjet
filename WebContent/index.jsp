<%@ include file="WEB-INF/includes/entete.jsp" %>	
	<span>ENI-Ench�res</span>
	<a style="float:right" href="http://localhost:8080/TrocObjet/PageConnexion">S'inscrire - Se connecter</a>
	
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