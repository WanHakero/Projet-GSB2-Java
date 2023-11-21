package Vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Class.Animateur;
import Controler.C_ManuAnimateur;
import Controler.C_MenuSalle;
import Modele.M_GSB2;

public class V_MenueAnimateur extends JPanel{
	
	private JButton AfficherAnimateur;
	private JButton AjouterAnimateur;
	private JButton SupprimerAnimateur;
	
	
	



	public V_MenueAnimateur (C_ManuAnimateur control) {
		
		this.setBounds(500,370,285,300);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder( "Animateur"));
		
		
		AfficherAnimateur = new JButton("Afficher");
		AfficherAnimateur.setEnabled(false);
		AfficherAnimateur.setBounds(10, 20, 90, 30);
		AfficherAnimateur.addActionListener(control);
		this.add(AfficherAnimateur);
		
		AjouterAnimateur = new JButton("Ajouter");
		AjouterAnimateur.setBounds(100, 20, 90, 30);
		AjouterAnimateur.addActionListener(control);
		this.add(AjouterAnimateur);
		
		SupprimerAnimateur = new JButton("Supprimer");
		SupprimerAnimateur.setBounds(190, 20, 90, 30);
		SupprimerAnimateur.addActionListener(control);
		this.add(SupprimerAnimateur);
		
	}
	
	public void estReponsable() {
		this.AjouterAnimateur.setVisible(false);
		this.SupprimerAnimateur.setVisible(false);
	}
	
	public JButton getAfficherAnimateur() {
		return AfficherAnimateur;
	}



	public void setAfficherAnimateur(JButton afficherAnimateur) {
		AfficherAnimateur = afficherAnimateur;
	}



	public JButton getAjouterAnimateur() {
		return AjouterAnimateur;
	}



	public void setAjouterAnimateur(JButton ajouterAnimateur) {
		AjouterAnimateur = ajouterAnimateur;
	}



	public JButton getSupprimerAnimateur() {
		return SupprimerAnimateur;
	}



	public void setSupprimerAnimateur(JButton supprimerAnimateur) {
		SupprimerAnimateur = supprimerAnimateur;
	}

	public void desactiverUnBtn(JButton btn) {
		JButton[] listBTN = new JButton[3];
		listBTN[0] = AfficherAnimateur;
		listBTN[2] = AjouterAnimateur;
		listBTN[1] =SupprimerAnimateur;
		
		for (int i = 0; i < 3; i++ ) {
			listBTN[i].setEnabled(true); 
		}
		btn.setEnabled(false);
		
	}

}
