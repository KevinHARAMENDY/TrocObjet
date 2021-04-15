<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Troc Objets</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
	</head>
	<body>	
		<span>ENI-Enchères</span>
		
		<C:choose>
			<C:when test="${empty sessionScope.User}">
				<a style="float:right" href="${pageContext.request.contextPath}/PageConnexion">S'inscrire - Se connecter</a>
			</C:when>
			<C:otherwise>
				<span style="float:right">
					Enchères 
					Vendre un article
					<a href="${pageContext.request.contextPath}/monProfil" title="MonProfil">Mon Profil</a>
					<a href="${pageContext.request.contextPath}/Deconnexion">Déconnexion</a>
				</span>
			</C:otherwise>
		</C:choose>
		
		<div style="text-align:center;color:red;font-weight:bold">Liste des enchères</div>
		
		<br><br><br>
		
		<form method="post" action="${pageContext.request.contextPath}/">
			<div class="container-fluid">Filtres : <input type="text" name="filtre"></div><br>
		
			<div class="container-fluid">Catégorie : 
			  <select name="categorie">
			  	<option selected></option>
			  	<C:forEach var="element" items="${requestScope.Categories}">
			  		<option>${element.libelle}</option>
			  	</C:forEach>
			  </select>
			</div><br>
		
		<!-- <a class="btn" href="${pageContext.request.contextPath}/supprimerProfil" title="supprimerProfil" onclick="return confirm('Confirmer la suppression du compte ?')">supprimerProfil</a>-->
		<C:if test="${!empty sessionScope.User}">
			<div style="display:inline-block;margin-left:2%">
				<div><input type="radio" name="achats" id="achats" onchange="clicAchats()"> Achats</div>
				<div><input type="radio" id="e_ouvertes" name="ach" value="e_ouvertes" disabled> <label for="e_ouvertes">enchères ouvertes</label></div>
				<div><input type="radio" id="e_cours" name="ach" value="e_cours" disabled> <label for="e_cours">mes enchères en cours</label></div>
				<div><input type="radio" id="e_remporte" name="ach" value="e_remporte" disabled> <label for="e_remporte">mes enchères remportées</label></div>
			</div>
			<div style="display:inline-block" class="position-absolute start-50">
				<div><input type="radio" name="ventes" id="ventes" onchange="clicVentes()"> Mes ventes</div>
				<div><input type="radio" id="v_cours" name="ven" value="v_cours" disabled> <label for="v_cours">ventes en cours</label></div>
				<div><input type="radio" id="v_n_debute" name="ven" value="v_n_debute" disabled> <label for="v_n_debute">ventes non débutées</label></div>
				<div><input type="radio" id="v_termine" name="ven" value="v_termine" disabled> <label for="v_termine">ventes terminées</label></div>
				
			</div>
		</C:if><br>
		
		<input type="submit" value="Rechercher">
		</form><br>
		
		<br><br>
		
			<%
				List<String> articles = (List<String>)request.getAttribute("Articles");
				for (String item : articles) {
					String[] tab = item.split("@");
			%>
				<div class="card" style="width: 18rem;display: inline-block">
				  <div class="card-body">
				    <h5 class="card-title"><%=tab[0].trim()%></h5>
				    <p class="card-text">Prix : <%=tab[1].trim()%> points</p>
				    <p class="card-text">Fin de l'enchère : <%=tab[2].trim()%></p>
				    <p class="card-text">Vendeur : <a href="${pageContext.request.contextPath}/afficherProfil?identifiant=<%=tab[3].trim()%>" title="afficherProfil"><%=tab[3].trim()%></a></p>
				  </div>
				</div>		
			<%
				}
			%>
			
			<script type="text/javascript">
				function clicAchats() {
					if (document.getElementById("achats").checked==1)
				    {
				        document.getElementById("e_ouvertes").disabled=false;
				        document.getElementById("e_ouvertes").checked=1;
				        document.getElementById("e_cours").disabled=false;
				        document.getElementById("e_remporte").disabled=false;
				        document.getElementById("ventes").checked=0;
				        document.getElementById("v_cours").disabled=true;
				        document.getElementById("v_n_debute").disabled=true;
				        document.getElementById("v_termine").disabled=true;
				    }
				}
	
				function clicVentes() {
					if (document.getElementById("ventes").checked==1)
				    {
						document.getElementById("e_ouvertes").disabled=true;
						document.getElementById("e_cours").disabled=true;
						document.getElementById("e_remporte").disabled=true;
				        document.getElementById("achats").checked=0;
				        document.getElementById("v_cours").disabled=false;
				        document.getElementById("v_cours").checked=1;
				        document.getElementById("v_n_debute").disabled=false;
				        document.getElementById("v_termine").disabled=false;
				    }
				}
			</script>
	</body>
</html>