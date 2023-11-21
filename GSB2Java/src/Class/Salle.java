package Class;

public class Salle {

		//Atribue
		private String nomSalle;
		private int nbPlaceMax;
		
		

		//Constructeur
		public Salle (String unNomSalle,int unNbPlaceMax ) {
			this.nomSalle = unNomSalle;
			this.nbPlaceMax = unNbPlaceMax ;
		
		}


		//Getters et Setters
		public String getNomSalle() {
			return nomSalle;
		}
		public void setNomSalle(String unNomSalle) {
			this.nomSalle = unNomSalle;
		}

		public int getNbPlaceMax() {
			return nbPlaceMax;
		}
		public void setNbPlaceMax(int unNbPlaceMax) {
			this.nbPlaceMax = unNbPlaceMax;
		}
		
	
}
