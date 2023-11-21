package Vue;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controler.C_Conference;
import Controler.C_ConferenceAction;

public class V_AjouterUneConference extends JPanel{
	
	private  JLabel txtAjouter;
	private JTextField ajoutertConference ;
	private JButton btnAjouter;
	
	public V_AjouterUneConference (C_ConferenceAction  controleur) {
		
		this.setBounds(0,0,300,200);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder( "Ajouter une conference"));
		
		
		this.txtAjouter = new JLabel("Theme :");
		this.txtAjouter.setBounds(30,45,70,25);
		this.add(txtAjouter);
		
		this.ajoutertConference = new  JTextField();
		this.ajoutertConference.setBounds(30,70,200,25);
		this.add(ajoutertConference);
		
		this.btnAjouter = new JButton("Ajouter");
		this.btnAjouter.setBounds(180,115,100,40);
		this.btnAjouter.addActionListener(controleur);
		this.add(btnAjouter);
		
		
		this.setVisible(true);
		
	}
	public String getTxtTheme() {
		return this.ajoutertConference.getText();
	}

}
