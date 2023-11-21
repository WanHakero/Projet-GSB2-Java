package Vue;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controler.C_MenuSalleAction;

public class V_ajouterSalle extends JPanel {
	
	private JLabel ajouterNomSalleLab;
	private JTextField ajouterNomSalleField;
	
	private JLabel ajouterNbPlaceSalleLab;
	private JTextField ajouterNbPlaceSalleField;
	
	private JButton ajouterSalleButton;
	private JLabel info;
	
	
	public  V_ajouterSalle(C_MenuSalleAction  control) {
	this.setBounds(0,50,285,250);
	
	this.setBackground(Color.white);
	this.setLayout(null);
	this.setBorder(BorderFactory.createTitledBorder( "Salle"));
	
	ajouterNomSalleLab = new JLabel("Nom :");
	ajouterNomSalleLab.setBounds(25, 25, 200, 30);
	this.add(ajouterNomSalleLab);
	
	ajouterNomSalleField = new JTextField();
	ajouterNomSalleField.setBounds(25, 60, 150, 30);
	this.add(ajouterNomSalleField);
	
	ajouterNbPlaceSalleLab = new JLabel("Nombre de place :");
	ajouterNbPlaceSalleLab.setBounds(25, 90, 200, 30);
	this.add(ajouterNbPlaceSalleLab);
	
	ajouterNbPlaceSalleField = new JTextField();
	ajouterNbPlaceSalleField.setBounds(25, 120, 150, 30);
	this.add(ajouterNbPlaceSalleField);
	
	ajouterSalleButton = new JButton("Ajouter");
	ajouterSalleButton.setBounds(150, 160, 100, 30);
	ajouterSalleButton.addActionListener(control);
	this.add(ajouterSalleButton);
	
	info = new JLabel();
	info.setBounds(2, 212, 285, 40);
	info.setBorder(BorderFactory.createTitledBorder(""));
	this.add(info);
	
	
	
	}


	public String getAjouterNomSalleFieldTXT() {
		return ajouterNomSalleField.getText();
	}


	public void setAjouterNomSalleField(JTextField ajouterNomSalleField) {
		this.ajouterNomSalleField = ajouterNomSalleField;
	}


	public String getAjouterNbPlaceSalleFieldTXT() {
		return ajouterNbPlaceSalleField.getText();
	}


	public void setAjouterNbPlaceSalleFieldTXT(JTextField ajouterNbPlaceSalleField) {
		this.ajouterNbPlaceSalleField = ajouterNbPlaceSalleField;
	}


	public JLabel getInfo() {
		return info;
	}


	public void setInfoTXT(String info) {
		this.info.setText(info);;
	}
	
	
}
