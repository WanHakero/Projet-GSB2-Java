package Class;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class Presentation {
	//Atribue
	private int id;
	private Time duree;
	private int nbPlaceDispo;
	private Date datePlanning;
	private Time horaireDebut;

	private String salle;
	private int animateur;
	


	
	//Constructeur
	public Presentation(int unId ,Time uneDuree ,int  unNbPlaceDispo,Date uneDate ,Time uneHoraire,String uneSalle,int unAnimateur) {
		this.id = unId;
		this.duree = uneDuree;
		this.nbPlaceDispo = unNbPlaceDispo;
		this.datePlanning = uneDate; 
		this.horaireDebut = uneHoraire;
		
		this.salle = uneSalle;
		this.animateur = unAnimateur;
		
		
	}
	
	//Getters et Setters
	
	public int getNbPlaceDispo() {
		return nbPlaceDispo;
	}
	public Date getDatePlanning() {
		return datePlanning;
	}

	public void setDatePlanning(Date datePlanning) {
		this.datePlanning = datePlanning;
	}

	public Time getHoraireDebut() {
		return horaireDebut;
	}

	public void setHoraireDebut(Time horaireDebut) {
		this.horaireDebut = horaireDebut;
	}

	public String getSalle() {
		return salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}

	public int getAnimateur() {
		return animateur;
	}

	public void setAnimateur(int animateur) {
		this.animateur = animateur;
	}

	public void setNbPlaceDispo(int nbPlaceDispo) {
		this.nbPlaceDispo = nbPlaceDispo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Time getDuree() {
		return duree;
	}

	public void setDuree(Time duree) {
		this.duree = duree;
	}

	//A changée de place
	
	
}
