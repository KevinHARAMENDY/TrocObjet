package bo;

import java.io.Serializable;

public class Retraits implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArticlesVendu noArticle;
	private String rue;
	private String code_postal;
	private String ville;
	
	public Retraits() {}

	public Retraits(ArticlesVendu noArticle, String rue, String code_postal, String ville) {
		super();
		this.noArticle = noArticle;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}

	public ArticlesVendu getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(ArticlesVendu noArticle) {
		this.noArticle = noArticle;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
