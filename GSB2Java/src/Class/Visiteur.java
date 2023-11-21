package Class;

public class Visiteur {
		//Atribue
		private String nom;
		private String prenom;
		
		

		//Constructeur
		public  Visiteur(String unNom,String unPrenom) {
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

}
