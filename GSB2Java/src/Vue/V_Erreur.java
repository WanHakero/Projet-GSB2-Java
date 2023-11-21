package Vue;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controler.C_ConnexionUtilisateur;
import Controler.C_Erreur;

import javax.swing.JLabel;

public class V_Erreur extends JPanel {
	// Attribut
	
	private JLabel erreurtxt ;
	private JButton erreurRetour ;
	private String message;
	
	// Accesseur
	
	public JLabel getErreurtxt() {
		return this.erreurtxt;
	}
	
	public JButton getErreurRetour() {
		return this.erreurRetour;
	}
	
	// Constructeur
	
	public V_Erreur (C_Erreur controlErreur) {
		// Instanciation
		
		erreurtxt  = new JLabel();
		erreurRetour  = new JButton();
		
		// ----------- METHODES -----------
		
		
			this.setBounds(160,150,450,200);
			this.setBackground(Color.lightGray);
			this.setLayout(null);
			this.setBorder(BorderFactory.createTitledBorder("Erreur"));
			
			// Affichage 
			
			this.erreurtxt = new JLabel(message);
			this.erreurtxt.setBounds(110,40,500,30);
			this.add(this.erreurtxt);
			
			this.erreurRetour = new JButton("Retour");
			this.erreurRetour.setBounds(130,100,200,30);
			this.erreurRetour.addActionListener(controlErreur);
			this.add(this.erreurRetour);
			
			this.setVisible(true);	
	}
	
	public void updateMessage (String message) {	
		this.erreurtxt.setText(message);
	}
	
	
	
	
}

