package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Class.Animateur;
import Class.Salle;
import Main.Main;
import Modele.M_GSB2;

public class C_MenuAnimateurAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event)   {

		switch(event.getActionCommand()){
	
		case "Ajouter":

			String nomAnimateur = Main.ajouterAnimateur.getNomAnimateurTXT();
			String prenomAnimateur = Main.ajouterAnimateur.getPrenomAnimateurTXT();
			
			if(nomAnimateur.isEmpty()|| prenomAnimateur.isEmpty()) {
				Main.ajouterAnimateur.setInfoTXT("Les 2 champs doit etre remplie");
				
			}else {
				Animateur unAnimateur = new Animateur(nomAnimateur,prenomAnimateur);
				    
				    if(M_GSB2.creerUnAnimateure(unAnimateur) == false) {
				    	Main.ajouterAnimateur.setInfoTXT("L'animateur existe déja");
				    }else {
				    	Main.ajouterAnimateur.setInfoTXT("L'animateur  a éte bien ajouter");
				    	
				    	
				    	Main.afficherAnimateur.removeAll();
				    	Main.afficherAnimateur.recreer();
				    	
						
				    	Main.suprimerAnimateur.removeAll();
				    	Main.suprimerAnimateur.recreer(this);
				    	
				    	
				    	M_GSB2.affichePanelTab(Main.tabMenuAnimateurPanel, 1);
				    	

			
			}
			}
		break;
		
		
		case "Supprimer":
			int id =Main.suprimerAnimateur.getIdAnimateur();
			
			if(M_GSB2.SupprimerUnAnimateure(id)== true) {
				

		    	Main.afficherAnimateur.removeAll();
		    	Main.afficherAnimateur.recreer();
		    	
				
		    	Main.suprimerAnimateur.removeAll();
		    	Main.suprimerAnimateur.recreer(this);
		  
		    	
		    	Main.suprimerAnimateur.setInfoTXT("La salle a éte bien supprimer");
		    	M_GSB2.affichePanelTab(Main.tabMenuAnimateurPanel, 2);
			}else {
				Main.suprimerSalle.setInfoTXT("La salle est utilisé par une presntation");
			}
			
			
			
		break;
		
		}
	}
}


