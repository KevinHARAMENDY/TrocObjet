<%@ include file="includes/entete.jsp" %>

	<div>ENI-Ench�res</div>
	
	<div style="text-align:center;color:red;font-weight:bold">Nouvelle vente</div>
	
	<br><br><br>
	
	<div class="container-fluid">Article : <input type="text" name="article"></div><br>
	<div class="container-fluid">Description : <textarea name="description"></textarea></div><br>
	
	<div class="container-fluid">Cat�gorie : 
	  <select name="categorie">
	  	<option>Informatique</option>
	  	<option>Ameublement</option>
	  	<option>V�tement</option>
	  	<option>Sport&Loisirs</option>
	  </select>
	</div><br>
	
	<div class="container-fluid">Photo de l'article : <input type="file" name="photo" /></div><br>
	<div class="container-fluid">Mise � prix : <input type="number" name="prix" /></div><br>
	<div class="container-fluid">D�but de l'ench�re : <input type="date" name="d�but" /></div><br>
	<div class="container-fluid">Fin de l'ench�re : <input type="date" name="fin" /></div><br>

	<br><br>
	<div class="container-fluid" style="font-weight:bold">Retrait</div><br>
	<div class="container-fluid">Rue : <input type="text" name="rue" /></div><br>
	<div class="container-fluid">Code postal : <input type="text" name="cp" /></div><br>
	<div class="container-fluid">Ville : <input type="text" name="ville" /></div><br>

	<div class="container-fluid"><input type="button" style="margin-left:47%" value="Enregistrer"></div><br>
	<div class="container-fluid"><input type="button" style="margin-left:48%" value="Annuler"></div><br>

	</body>
</html>