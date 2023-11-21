package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Class.Conference;
import Main.Main;
import Modele.M_GSB2;
import Vue.V_MenuSalle;
import Vue.V_Presentat;

public class C_MenuSalle implements ActionListener{

	
	@Override
	public void actionPerformed(ActionEvent event)   {
	
		switch(event.getActionCommand()){
		
		case "Afficher":
			Main.menuSalle.desactiverUnBtn(Main.menuSalle.getAfficherSalle());
			M_GSB2.affichePanelTab(Main.tabMenuSallePanel, 0);
			
		break;
		case "Ajouter":
			Main.menuSalle.desactiverUnBtn(Main.menuSalle.getAjouterSalle());
			M_GSB2.affichePanelTab(Main.tabMenuSallePanel, 1);
			
		
		break;
		case "Supprimer":
			Main.menuSalle.desactiverUnBtn(Main.menuSalle.getSupprimerSalle());
			M_GSB2.affichePanelTab(Main.tabMenuSallePanel, 2);
			
			
		break;
		
		}
	}
}
