package Controler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Class.Conference;
import Main.Main;
import Modele.M_GSB2;
import Vue.V_Presentat;


public class C_ConferenceAction implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event)  {
	
		System.out.println("aa");
		switch(event.getActionCommand()){
		

		
		case "Ajouter":
			String themeA  = Main.ajouterConference.getTxtTheme();
			Conference uneConference = new Conference(themeA);
			M_GSB2.creerUneConference(uneConference);
			System.out.println("bb");
			Main.menuePresentation.removeAll();
			Main.menuePresentation = new  V_Presentat(Main.controlConference);
			M_GSB2.ajoutPanel(Main.menuePresentation);
			M_GSB2.inviblePanel();
			Main.menuePresentation.setVisible(true);;
		
			break;
			
		}
}
}
