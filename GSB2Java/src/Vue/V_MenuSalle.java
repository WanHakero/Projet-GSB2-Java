package Vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Class.Salle;
import Controler.C_MenuSalle;
import Modele.M_GSB2;

public class V_MenuSalle extends JPanel{
	
	private JButton AfficherSalle;
	private JButton AjouterSalle;
	private JButton SupprimerSalle;
	
	public V_MenuSalle(C_MenuSalle control) {
		
		this.setBounds(500,70,285,300);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder( "Menu Salle"));
		
		
		AfficherSalle = new JButton("Afficher");
		AfficherSalle.setEnabled(false);
		AfficherSalle.setBounds(10, 20, 90, 30);
		AfficherSalle.addActionListener(control);
		this.add(AfficherSalle);
		
		AjouterSalle = new JButton("Ajouter");
		AjouterSalle.setBounds(100, 20, 90, 30);
		AjouterSalle.addActionListener(control);
		this.add(AjouterSalle);
		
		SupprimerSalle = new JButton("Supprimer");
		SupprimerSalle.setBounds(190, 20, 90, 30);
		SupprimerSalle.addActionListener(control);
		this.add(SupprimerSalle);
		
		
	}
	public void estReponsable() {
		this.AjouterSalle.setVisible(false);
		this.SupprimerSalle.setVisible(false);
	}
	

	public JButton getAfficherSalle() {
		return AfficherSalle;
	}

	public void setAfficherSalle(JButton afficherSalle) {
		AfficherSalle = afficherSalle;
	}

	public JButton getAjouterSalle() {
		return AjouterSalle;
	}

	public void setAjouterSalle(JButton ajouterSalle) {
		AjouterSalle = ajouterSalle;
	}

	public JButton getSupprimerSalle() {
		return SupprimerSalle;
	}

	public void setSupprimerSalle(JButton supprimerSalle) {
		SupprimerSalle = supprimerSalle;
	}
	
	public void desactiverUnBtn(JButton btn) {
		JButton[] listBTN = new JButton[3];
		listBTN[0] = AfficherSalle;
		listBTN[2] = AjouterSalle;
		listBTN[1] =SupprimerSalle;
		
		for (int i = 0; i < 3; i++ ) {
			listBTN[i].setEnabled(true); 
		}
		btn.setEnabled(false);
		
	}
	

}
