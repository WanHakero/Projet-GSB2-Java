package Class;

public class Inscription {
	//Atribue
	private Visiteur visiteur;
	private Presentation presentation;
	private Statut statut;
	
	//Constructeur
	public Inscription (Visiteur unVisiteur ,Presentation unePresentation,Statut unStatut){
		this.visiteur = unVisiteur;
		this.presentation = unePresentation;
		this.statut =unStatut;
	}

	//Getters et Setters
	public Visiteur getVisiteur() {
		return visiteur;
	}

	public void setVisiteur(Visiteur visiteur) {
		this.visiteur = visiteur;
	}

	public Presentation getPresentation() {
		return presentation;
	}

	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
	}

}
