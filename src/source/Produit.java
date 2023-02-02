package source;

public class Produit {

	private  int  code ;
	private  String nom ;
	private  String description ;
	private  int quantite ;
	private  int seuil ;
	
	

	public Produit(int code, String nom, String description, int quantite, int seuil) {
		this.code = code;
		this.nom = nom;
		this.description = description;
		this.quantite = quantite;
		this.seuil = seuil;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getSeuil() {
		return seuil;
	}

	public void setSeuil(int seuil) {
		this.seuil = seuil;
	}
	
	
}
