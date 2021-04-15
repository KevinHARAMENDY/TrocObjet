package bo;

import java.io.Serializable;

public class Utilisateurs implements Serializable {
	private static final long serialVersionUID = 1L;
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String tel;
	private String rue;
	private String code_postal;
	private String ville;
	private String mdp;
	private int credit;
	private boolean admin;
	
	public Utilisateurs() {}

	public Utilisateurs(int noUtilisateur, String pseudo, String nom, String prenom, String email, String tel,
			String rue, String code_postal, String ville, String mdp, int credit, boolean admin) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mdp = mdp;
		this.credit = credit;
		this.admin = admin;
	}
	
	public Utilisateurs(String pseudo, String nom, String prenom, String email, String tel,
			String rue, String code_postal, String ville, String mdp) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mdp = mdp;
	}
	
	public Utilisateurs(String pseudo, String mdp) {
		this.pseudo = pseudo;
		this.mdp = mdp;
	}
	
	
	
	/**Contructeur Utilisateurs
	 * @param noUtilisateur
	 * @param pseudo
	 * @param tel
	 */
	public Utilisateurs(int noUtilisateur, String pseudo, String tel) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.tel = tel;
	}

	/**
	 * Constructeur Utilisateurs avec noUtilisateur
	 * 
	 * @param noUtilisateur
	 */
	public Utilisateurs(int noUtilisateur) {
		super();
		this.noUtilisateur = noUtilisateur;
	}

	/**
	 * Constructeur Utilisateurs sans le mdp
	 * 
	 * @param noUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param tel
	 * @param rue
	 * @param code_postal
	 * @param ville
	 * @param credit
	 * @param admin
	 */
	public Utilisateurs(int noUtilisateur, String pseudo, String nom, String prenom, String email, String tel,
			String rue, String code_postal, String ville, int credit, boolean admin) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.credit = credit;
		this.admin = admin;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
