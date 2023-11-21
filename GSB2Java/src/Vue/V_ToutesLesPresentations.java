package Vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import Class.Presentation;
import Controler.C_Conference;
import Controler.C_Presentation;
import Modele.M_GSB2;

public class V_ToutesLesPresentations extends JPanel{
	
	private JButton btnAjouter;
	private JLabel titreConference;

	private JPanel[] lesPanelPressentation;
	
	private JLabel[] dateP;
	private JLabel[] horraireP;
	
	private JLabel[] dureeP;
	private JLabel[] nombrePlaceP;
	
	private JPanel[] lesPanelPressentationBTN;
	private JButton[] btnModifier;
	private JButton[] btnSupprimer;
	private JButton[] btnInfoSupplementaire;
	private JButton[] btnStats;
	
	private int[] idPresentattion;
	
	private int taileTab;
	
	
	
	public V_ToutesLesPresentations (int id,C_Presentation controler) {
		
		this.setBounds(0,70,500,690);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder( "Presentation"));
		
		this.btnAjouter = new JButton("Nouvelle Presentation");
		this.btnAjouter.setBounds(20,20,170,30);
		this.add(btnAjouter);
		
		
		
	/*	this.scrollPanlPresentation = new JScrollPane();
		this.scrollPanlPresentation.setBounds(45, 70, 700, 500);
		this.scrollPanlPresentation.setBackground(Color.red);
		this.add(scrollPanlPresentation);*/
		
		lesPresentation(id,controler);
		
	

	
		
		this.setVisible(true);
	}

	
	
	public void lesPresentation(int id,C_Presentation controler) {
		int i = 0;
		ArrayList<Presentation> listPresentation = M_GSB2.getLesPresentation(id);
		taileTab = listPresentation.size();
		this.lesPanelPressentation = new JPanel[taileTab];
		this.lesPanelPressentationBTN = new JPanel[taileTab];
		
		this.btnInfoSupplementaire = new JButton[taileTab];
		this.btnModifier = new JButton[taileTab];
		this.btnSupprimer = new JButton[taileTab];
		this.btnStats = new JButton[taileTab];
		
		dateP = new JLabel[taileTab];
		horraireP = new JLabel[taileTab];
		dureeP = new JLabel[taileTab];
		nombrePlaceP = new  JLabel[taileTab];
		
		idPresentattion = new int[taileTab];
		 
		
		
		
		for(Presentation lesListPresentation : listPresentation  ) {
			this.lesPanelPressentation[i] = new JPanel();
			this.lesPanelPressentation[i].setLayout(null);
			this.lesPanelPressentation[i].setBounds(10,70+(i*150),480,50);
			//this.lesPanelPressentation[i].setBackground(Color.cyan);
			this.lesPanelPressentation[i].setBorder(BorderFactory.createTitledBorder( "Conference"));
			this.add(this.lesPanelPressentation[i]);
			
	
			idPresentattion[i]=lesListPresentation.getId();
			
			this.dateP[i] = new JLabel("Date : "+lesListPresentation.getDatePlanning());
			this.dateP[i].setBounds(10, 20, 100, 25);
			this.lesPanelPressentation[i].add(dateP[i]);
			
			this.horraireP[i] = new JLabel("Debut : "+lesListPresentation.getHoraireDebut().getHours()+"h"+lesListPresentation.getHoraireDebut().getMinutes());
			this.horraireP[i].setBounds(130, 20, 100, 25);
			this.lesPanelPressentation[i].add(horraireP[i]);
			
			this. dureeP[i] = new JLabel("Duree : "+lesListPresentation.getDuree().getHours()+"h"+lesListPresentation.getDuree().getMinutes());
			this. dureeP[i].setBounds(220, 20, 100, 25);
			this.lesPanelPressentation[i].add( dureeP[i]);
			

			this. nombrePlaceP[i] = new JLabel("Place disponible : "+lesListPresentation.getNbPlaceDispo());
			this. nombrePlaceP[i].setBounds(330, 20, 200, 25);
			this.lesPanelPressentation[i].add( nombrePlaceP[i]);
			
			
			this.lesPanelPressentationBTN[i]= new JPanel();
			this.lesPanelPressentationBTN[i].setLayout(null);
			this.lesPanelPressentationBTN[i].setBounds(10,70+(i*150),480,100);
		//	this.lesPanelPressentationBTN[i].setBackground(Color.MAGENTA);
			this.lesPanelPressentationBTN[i].setBorder(BorderFactory.createTitledBorder( "Conference"));
			this.add(this.lesPanelPressentationBTN[i]);
			
			this.btnInfoSupplementaire[i] = new JButton("Plus d'info");
			this.btnInfoSupplementaire[i].setBounds(370, 55, 100,35);
			this.btnInfoSupplementaire[i].addActionListener(controler);
			this.lesPanelPressentationBTN[i].add(btnInfoSupplementaire[i]);
			
			this.btnModifier[i] = new JButton("Modifier");
			this.btnModifier[i].setBounds(260, 55, 100,35);
			this.btnModifier[i].addActionListener(controler);
			this.lesPanelPressentationBTN[i].add(btnModifier[i]);
			
			this.btnSupprimer[i] = new JButton("Supprimer");
			this.btnSupprimer[i].setBounds(150, 55, 100,35);
			this.btnSupprimer[i].addActionListener(controler);
			this.lesPanelPressentationBTN[i].add(btnSupprimer[i]);
			
			this.btnStats[i] = new JButton("Stats");
			this.btnStats[i].setBounds(40, 55, 100,35);
			this.btnStats[i].addActionListener(controler);
			this.lesPanelPressentationBTN[i].add(btnStats[i]);
			this.btnStats[i].setVisible(false);
			i++;
			
		}
		
		
		
	}
	
	public void estReponsable(int id) {
		ArrayList<Presentation> listPresentation = M_GSB2.getLesPresentation(id);
		int i = 0;
		for(Presentation lesListPresentation : listPresentation  ) {
			this.btnInfoSupplementaire[i].setVisible(false);
			this.btnModifier[i].setVisible(false);
			this.btnSupprimer[i].setVisible(false);
			this.btnStats[i].setVisible(true);
			i++;
		}
	}
	public int[] getIdPresntation() {
		return idPresentattion;
	}



	public JButton getBtnAjouter() {
		return btnAjouter;
	}



	public void setBtnAjouter(JButton btnAjouter) {
		this.btnAjouter = btnAjouter;
	}



	public JButton[] getBtnModifier() {
		return btnModifier;
	}



	public void setBtnModifier(JButton[] btnModifier) {
		this.btnModifier = btnModifier;
	}



	public JButton[] getBtnSupprimer() {
		return btnSupprimer;
	}



	public void setBtnSupprimer(JButton[] btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

	public JButton[] getBtnStats() {
		return btnStats;
	}



	public void setBtnStats(JButton[] Stats) {
		this.btnStats= Stats;
	}



	public JButton[] getBtnInfoSupplementaire() {
		return btnInfoSupplementaire;
	}



	public void setBtnInfoSupplementaire(JButton[] btnInfoSupplementaire) {
		this.btnInfoSupplementaire = btnInfoSupplementaire;
	}



	public int getTaileTab() {
		return taileTab;
	}



	public void setTaileTab(int taileTab) {
		this.taileTab = taileTab;
	}
}
