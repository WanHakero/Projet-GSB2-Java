package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.Main;
import Modele.M_GSB2;

public class C_ManuAnimateur implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event)   {
	
		switch(event.getActionCommand()){
		
		case "Afficher":
			Main.menuAnimateur.desactiverUnBtn(Main.menuAnimateur.getAfficherAnimateur());
			M_GSB2.affichePanelTab(Main.tabMenuAnimateurPanel, 0);
			
		break;
		case "Ajouter":
			Main.menuAnimateur.desactiverUnBtn(Main.menuAnimateur.getAjouterAnimateur());
			M_GSB2.affichePanelTab(Main.tabMenuAnimateurPanel, 1);
			
		
		break;
		case "Supprimer":
			Main.menuAnimateur.desactiverUnBtn(Main.menuAnimateur.getSupprimerAnimateur());
			M_GSB2.affichePanelTab(Main.tabMenuAnimateurPanel, 2);
			
			
		break;
		
		}
	}
}
