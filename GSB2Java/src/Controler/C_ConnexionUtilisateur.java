package Controler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.Main;
import Modele.M_GSB2;

public class C_ConnexionUtilisateur  implements ActionListener{
	//private String responsable;
	static public int fonction;
	@Override
	public void actionPerformed(ActionEvent event) {
	
	
		switch(event.getActionCommand()){
		
		case "Valider":
			String loginUser = Main.connexion.getLogintxt().getText();	// Recupere le login entr�e par l'utilisateur
			String mdpUser = Main.connexion.getMdptxt().getText();	// Recupere le mdp entr�e par l'utilisateur
			//System.out.println(M_GSB2.ConnectionUtilisateur(loginUser,mdpUser));
			if (M_GSB2.ConnectionUtilisateur(loginUser,mdpUser) == true) {
				//grade = M_GSB2.getEmploiUtilisateur(loginUser,mdpUser);
				M_GSB2.inviblePanel();
				Main.menuePresentation.setVisible(true);
				Main.menuSalle.setVisible(true);
				Main.menuAnimateur.setVisible(true);
				Main.menuFichier.setVisible(true);
				Main.controlErreur.panelRetour = Main.menuePresentation;
				fonction = M_GSB2.getEmploiUtilisateurID(loginUser,mdpUser);
				if(fonction == 2) {
					//Affiche vue du responsable
				
					Main.menuAnimateur.estReponsable();
					Main.menuSalle.estReponsable();
					Main.menuePresentation.estReponsable();
					
				}
				
			}else{
				// Affiche l'erreur 
				Main.erreur.updateMessage(" Erreur, l'un des deux champs est erron�.");
				M_GSB2.inviblePanel();
				Main.erreur.setVisible(true);
				Main.controlErreur.panelRetour = Main.connexion;
				//System.out.println(" Erreur, au moins l'un des deux champs est erron�. ");
			}
		break;
		
		}
	}
}
