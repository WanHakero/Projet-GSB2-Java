
package Controler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Class.Presentation;
import Main.Main;
import Modele.M_GSB2;
import Vue.V_Presentat;
import Vue.V_ToutesLesPresentations;

public class C_Conference implements ActionListener {
	
	String themeSelect;
	public static int idConference ;
	
	@Override
	public void actionPerformed(ActionEvent event)  {
	
		 themeSelect  =  Main.menuePresentation.getTxtListConference();
		 idConference = Main.menuePresentation.getIDListConference();
		switch(event.getActionCommand()){
		case "Selectioner":
			Main.toutesPresentation = new V_ToutesLesPresentations(idConference,Main.contrpmPresentation);
			M_GSB2.ajoutPanel(Main.toutesPresentation);
			M_GSB2.inviblePanel();
			Main.menuePresentation.setVisible(true);
			Main.toutesPresentation.setVisible(true);
			Main.menuSalle.setVisible(true);
			Main.menuAnimateur.setVisible(true);
			Main.menuFichier.setVisible(true);
			
			if(Main.uneConnexUtil.fonction == 2) {
				Main.toutesPresentation.estReponsable(idConference);
			}
			
			break;
		case "Supprimer":
			M_GSB2.SupprimerUnePresentationConference(idConference);
			M_GSB2.SupprimerUneConference( idConference );
			
			ArrayList<Presentation> listPresentation = M_GSB2.getLesPresentation(idConference);
			
			for(Presentation lesListPresentation : listPresentation  ) {
				M_GSB2.supprimerUnePresentation(lesListPresentation.getId());
			}
			
			
			
			Main.menuePresentation.removeAll();
			Main.menuePresentation = new  V_Presentat(Main.controlConference);
			M_GSB2.ajoutPanel(Main.menuePresentation);
			M_GSB2.inviblePanel();
			Main.menuePresentation.setVisible(true);
			break;
		case "Ajouter":
			M_GSB2.inviblePanel();
			Main.ajouterConference.setVisible(true);
		
			break;
			
		}
}

	public String getThemeSelect() {
		return themeSelect;
	}

	public void setThemeSelect(String themeSelect) {
		this.themeSelect = themeSelect;
	}

	public int getIdConference() {
		return idConference;
	}

	public void setIdConference(int idConference) {
		this.idConference = idConference;
	}
	
	
}
