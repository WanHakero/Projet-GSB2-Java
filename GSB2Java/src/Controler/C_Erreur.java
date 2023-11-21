package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Main.Main;
import Modele.M_GSB2;

public class C_Erreur implements ActionListener {
	
	static public JPanel panelRetour;
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
	
	
		switch(event.getActionCommand()){
		
		case "Retour":
			//Permet de revenir sur la vue connexion
			M_GSB2.inviblePanel();
			panelRetour.setVisible(true);
		break;
		
		}
	}
}
