<%@ include file="includes/entete.jsp" %>
	<div>ENI-Ench�res</div>
	
	<div style="text-align:center;color:red;font-weight:bold">Connexion</div>
	
	<br><br><br>	
	
	<form method="post" action="/TrocObjet/PageConnexion">
		<div class="container-fluid">Identifiant : <input type="text" name="identifiant"></div><br>
		<div class="container-fluid">Mot de passe : <input type="password" name="mdp"></div><br>
		<div class="container-fluid"><input type="submit" value="Connexion"></div><br>
		<div class="container-fluid"><input type="checkbox"> Se souvenir de moi</div><br>
	</form>
	
	<div class="container-fluid">Mot de passe oubli�</div><br>
	
	<br><br>
	
	<div class="container-fluid"><input type="button" value="Cr�er un compte"></div><br>

	</body>
</html>