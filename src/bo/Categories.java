package bo;

import java.io.Serializable;

public class Categories implements Serializable {
	private static final long serialVersionUID = 1L;
	private int noCategorie;
	private String libelle;
	
	public Categories() {}

	public Categories(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
