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
					<a href="${pageContext.request.contextPath}/Deconnexion">Déconnexion</a>
		
					<%-- 			<a class="btn" href="${pageContext.request.contextPath}/monProfil" title="MonProfil">Mon Profil</a> --%>
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
			
			<input type="submit" value="Rechercher">
		</form>
		
		<a class="btn" href="${pageContext.request.contextPath}/supprimerProfil" title="supprimerProfil" onclick="return confirm('Confirmer la suppression du compte ?')">supprimerProfil</a>
		
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
	</body>
</html>