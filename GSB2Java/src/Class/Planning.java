package Class;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


public class Planning {
	//Atribue
	private Date datePlanning;
	private Time horaireDebut;
	private int presentation;
	private String salle;
	private int animateur;
	
	
	
	//Constructeur
	public Planning(Date uneDate ,Time uneHoraire,int unPresentation,String uneSalle,int unAnimateur) {
		this.datePlanning = uneDate; 
		this.horaireDebut = uneHoraire;
		this.presentation = unPresentation;
		this.salle = uneSalle;
		this.animateur = unAnimateur;
	
	}

	//Getters et Setters
	


	@Override
	public String toString() {
		return "Planning [datePlanning=" + datePlanning + ", horaireDebut=" + horaireDebut + "]";
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

	public int getPresentation() {
		return presentation;
	}

	public void setPresentation(int presentation) {
		this.presentation = presentation;
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
 
}
