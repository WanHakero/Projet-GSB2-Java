package Vue;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controler.C_ConnexionUtilisateur;

public class V_Connexion extends JPanel  {
	
	// ----------- ATTRIBUTS -----------
		// Titres
		private JLabel login;
		private JLabel mdp;
		
		// Champs � remplir
		private JTextField logintxt ;
		private JPasswordField mdptxt;
		
		// Validation
		private JButton valider;
		
	

		
	
	// ----------- CONSTRUCTEURS -----------
	

	public V_Connexion (C_ConnexionUtilisateur uneConnexUtil) {
		//
		// ----------- METHODES -----------
		
		
		this.setBounds(160,150,450,400);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder("Connexion"));
		
		// Affichage Login
		
			this.login = new JLabel("Login");
			this.login.setBounds(110,80,200,40);
			this.add(this.login);
			
			this.logintxt = new JTextField();
			this.logintxt.setBounds(110,120,200,30);
			this.add(this.logintxt);
		
		// Affichage Mdp
		
			this.mdp = new JLabel("Mdp");
			this.mdp.setBounds(110,150,200,40);
			this.add(this.mdp);
			
			this.mdptxt = new JPasswordField();
			this.mdptxt.setBounds(110,190,200,30);
			this.add(this.mdptxt);
			
		// Affichage boutton
				
			this.valider = new JButton("Valider");
			this.valider.setBounds(170,250,100,30);
			this.valider.addActionListener(uneConnexUtil);
			this.add(this.valider);
			
			this.setVisible(true);
	}
	
	
	//Accesseurs 
	
	public JLabel getLogin () {
		return this.login;
	}
	
	public JLabel getMdp () {
		return this.mdp;
	}
	
	public JTextField getLogintxt() {
		return logintxt;
	}

	public void setLogintxt(JTextField logintxt) {
		this.logintxt = logintxt;
	}

	public JPasswordField getMdptxt() {
		return mdptxt;
	}

	public void setMdptxt(JPasswordField mdptxt) {
		this.mdptxt = mdptxt;
	}
	
	
	
	
	
	
	
}
