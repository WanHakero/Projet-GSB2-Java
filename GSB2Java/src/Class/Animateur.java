package Class;

public class Animateur {
	//Atribue
	private int id;
	private String nom;
	private String prenom;
	
	

	//Constructeur
	public Animateur(int unId,String unNom,String unPrenom) {
		this.nom = unNom;
		this.prenom = unPrenom;
		this.id  = unId;
	}
	
	public Animateur(String unNom,String unPrenom) {
		this.nom = unNom;
		this.prenom = unPrenom;
	}
	
	//Getters et Setters
	public String getNom() {
		return nom;
	}
	public void setNom(String unNom) {
		this.nom = unNom;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String unPrenom) {
		this.prenom = unPrenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
