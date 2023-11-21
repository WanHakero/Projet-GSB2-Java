package Vue;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controler.C_ManuAnimateur;
import Controler.C_MenuAnimateurAction;

public class V_AjouterAnimateur extends JPanel {

	private JLabel ajouterNomAnimateurLab;
	private JTextField ajouterNomAnimateurField;
	
	private JLabel ajouterPrenomAnimateurLab;
	private JTextField ajouterPrenomAnimateurField;
	
	private JButton ajouterAnimateurButton;
	private JLabel info;
	
	
	public  V_AjouterAnimateur(C_MenuAnimateurAction control) {
	this.setBounds(0,50,285,250);
	
	this.setBackground(Color.white);
	this.setLayout(null);
	this.setBorder(BorderFactory.createTitledBorder( "Animateur"));
	
	ajouterNomAnimateurLab = new JLabel("Nom :");
	ajouterNomAnimateurLab.setBounds(25, 25, 200, 30);
	this.add(ajouterNomAnimateurLab);
	
	ajouterNomAnimateurField = new JTextField();
	ajouterNomAnimateurField.setBounds(25, 60, 150, 30);
	this.add(ajouterNomAnimateurField);
	
	ajouterPrenomAnimateurLab = new JLabel("Prenom :");
	ajouterPrenomAnimateurLab.setBounds(25, 90, 200, 30);
	this.add(ajouterPrenomAnimateurLab);
	
	ajouterPrenomAnimateurField = new JTextField();
	ajouterPrenomAnimateurField.setBounds(25, 120, 150, 30);
	this.add(ajouterPrenomAnimateurField);
	
	ajouterAnimateurButton = new JButton("Ajouter");
	ajouterAnimateurButton.setBounds(150, 160, 100, 30);
	ajouterAnimateurButton.addActionListener(control);
	this.add(ajouterAnimateurButton);
	
	info = new JLabel();
	info.setBounds(2, 212, 285, 40);
	info.setBorder(BorderFactory.createTitledBorder(""));
	this.add(info);
	
	
	
	}
	
	public String getNomAnimateurTXT() {
		return ajouterNomAnimateurField.getText();
	}
	public String getPrenomAnimateurTXT() {
		return ajouterPrenomAnimateurField.getText();
	}
	public void setInfoTXT(String uneInfo) {
		info.setText(uneInfo);
	}
}
