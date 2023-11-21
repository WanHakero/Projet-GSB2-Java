
package Controler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.Main;
import Modele.M_GSB2;
import Vue.V_StatPresentation;
import Vue.V_ToutesLesPresentations;

public class C_Presentation implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event)  {
	
		for(int i = 0; i < Main.toutesPresentation.getTaileTab(); i++) {
			
			if (event.getSource() ==  Main.toutesPresentation.getBtnSupprimer()[i]) {
				
				int id =Main.toutesPresentation.getIdPresntation()[i];
				M_GSB2.supprimerUnePresentationDansLaListe(id);
		
				System.out.println(id);
				M_GSB2.supprimerUnePresentation(id);
				
				Main.toutesPresentation.removeAll();
				Main.toutesPresentation= new V_ToutesLesPresentations(C_Conference.idConference, Main.contrpmPresentation);
				M_GSB2.ajoutPanel(Main.toutesPresentation);
				M_GSB2.inviblePanel();
				Main.toutesPresentation.setVisible(true);
				Main.menuePresentation.setVisible(true);;
				Main.menuSalle.setVisible(true);
				Main.menuAnimateur.setVisible(true);
				Main.menuFichier.setVisible(true);
				
				
			}
			if (event.getSource() ==  Main.toutesPresentation.getBtnStats()[i]) {
				int id =Main.toutesPresentation.getIdPresntation()[i];
				Main.statPresntation.removeAll();
				Main.statPresntation = new V_StatPresentation(id,Main.contrpmPresentation);
				M_GSB2.ajoutPanel(Main.statPresntation);
				M_GSB2.inviblePanel();
				Main.statPresntation.setVisible(true);
				Main.menuePresentation.setVisible(true);;
				Main.menuSalle.setVisible(true);
				Main.menuAnimateur.setVisible(true);
				Main.menuFichier.setVisible(true);
				
			}
			
		}
		switch(event.getActionCommand()){
		

		
		case "Retour":
			
			M_GSB2.inviblePanel();
			Main.menuePresentation.setVisible(true);
			Main.toutesPresentation.setVisible(true);
			Main.menuSalle.setVisible(true);
			Main.menuAnimateur.setVisible(true);
			Main.menuFichier.setVisible(true);
			
			if(Main.uneConnexUtil.fonction == 2) {
				Main.toutesPresentation.estReponsable(Main.menuePresentation.getIDListConference());
			}
		break;
		}
	}
}

