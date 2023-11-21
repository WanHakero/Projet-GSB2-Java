package Class;

public class ListeDePresentation {
	//Atribue
	private int conference;
	private int presentation;
	
	//Constructeur
	public ListeDePresentation(int uneConference , int unePresentation) {
		this.conference = uneConference;
		this.presentation = unePresentation;
	
	}

	//Getters et Setters
	public int getConference() {
		return conference;
	}

	public void setConference(int  conference) {
		this.conference = conference;
	}

	public int  getPresentation() {
		return presentation;
	}

	public void setPresentation(int  presentation) {
		this.presentation = presentation;
	}

}
