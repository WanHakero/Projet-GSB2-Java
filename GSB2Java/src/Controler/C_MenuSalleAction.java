package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Class.Salle;
import Main.Main;
import Modele.M_GSB2;
import Vue.V_AfficherSalle;
import Vue.V_supprimerSalle;

public class C_MenuSalleAction implements ActionListener{

	
	@Override
	public void actionPerformed(ActionEvent event)   {

		switch(event.getActionCommand()){
	
		case "Ajouter":
			String nomSalle = Main.ajouterSalle.getAjouterNomSalleFieldTXT();
			String nbPlaceSalle = Main.ajouterSalle.getAjouterNbPlaceSalleFieldTXT();
			
			if(nomSalle.isEmpty()|| nbPlaceSalle.isEmpty()) {
				Main.ajouterSalle.setInfoTXT("Les 2 champs doit etre remplie");
				
			}else {
				try {
				    int nbPlace = Integer.parseInt(nbPlaceSalle);
				    Salle uneSalle = new Salle(nomSalle,nbPlace);
				    
				    if(M_GSB2.creerUneSalle(uneSalle) == false) {
				    	Main.ajouterSalle.setInfoTXT("La salle existe déja");
				    }else {
				    	Main.ajouterSalle.setInfoTXT("La salle a éte bien ajouter");
				    	
				    	
				    	Main.afficherSalle.removeAll();
				    	Main.afficherSalle.recreer();
						
				    	Main.suprimerSalle.removeAll();
				    	Main.suprimerSalle.recreer(this);
				    	
				    	
				    	M_GSB2.affichePanelTab(Main.tabMenuSallePanel, 1);
				    	
				    	
				    	
				    }
				} catch (NumberFormatException e){
				    // n'est pas un nombre, gérer ce cas
					Main.ajouterSalle.setInfoTXT("Mauvaise valeur");
				}
			}
			
		
		break;
		case "Supprimer":
			String uneSalle =Main.suprimerSalle.getTxtListSalleBox();
			
			if(M_GSB2.SupprimerUneSalle(uneSalle) == true) {
				
				
		    	Main.afficherSalle.removeAll();
		    	Main.afficherSalle.recreer();
				
		    	Main.suprimerSalle.removeAll();
		    	Main.suprimerSalle.recreer(this);;
		  
		    	
		    	Main.suprimerSalle.setInfoTXT("La salle a éte bien supprimer");
		    	M_GSB2.affichePanelTab(Main.tabMenuSallePanel, 2);
			}else {
				Main.suprimerSalle.setInfoTXT("La salle est utilisé par une presntation");
			}
			
			
			
		break;
		
		}
	}
}
