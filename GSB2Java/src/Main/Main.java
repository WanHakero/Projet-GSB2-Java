package Main;

import javax.swing.JPanel;

import Controler.C_Conference;
import Controler.C_ConferenceAction;
import Controler.C_ConnexionUtilisateur;
import Controler.C_Erreur;
import Controler.C_ManuAnimateur;
import Controler.C_MenuAnimateurAction;
import Controler.C_MenuSalle;
import Controler.C_Presentation;
import Controler.C_fihierAction;
import Modele.M_GSB2;
import Controler.C_MenuSalleAction;
import Vue.V_AfficherAnimateur;
import Vue.V_AfficherSalle;
import Vue.V_AjouterAnimateur;
import Vue.V_AjouterUneConference;
import Vue.V_Connexion;
import Vue.V_EnregisterFichier;
import Vue.V_Erreur;
import Vue.V_ajouterSalle;
import Vue.V_supprimerSalle;
import Vue.V_Frame;
import Vue.V_LienFichier;
import Vue.V_MenuFichier;
import Vue.V_MenuSalle;
import Vue.V_MenueAnimateur;
import Vue.V_Presentat;
import Vue.V_StatPresentation;
import Vue.V_SupprimerAnimateur;
import Vue.V_ToutesLesPresentations;

public class Main {
	
	public static V_Frame mainFrame ;
	public static V_Erreur erreur;
	public static V_Presentat menuePresentation;
	public static V_Connexion connexion;
	public static V_ToutesLesPresentations toutesPresentation;
	public static  V_AjouterUneConference ajouterConference;
	public static V_StatPresentation statPresntation;
	
	public static  V_MenuSalle menuSalle;
	
	public static V_AfficherSalle afficherSalle;
	public static  V_ajouterSalle ajouterSalle;
	public static V_supprimerSalle suprimerSalle;
	public static JPanel[] tabMenuSallePanel;
	
	public static V_MenueAnimateur menuAnimateur;
	
	public static V_AfficherAnimateur afficherAnimateur;
	public static  V_AjouterAnimateur ajouterAnimateur;
	public static V_SupprimerAnimateur suprimerAnimateur;
	public static JPanel[] tabMenuAnimateurPanel;
	
	public static V_MenuFichier menuFichier;
	public static V_EnregisterFichier fichierEnregister;
	public static V_LienFichier lienFichier;
	
	public static C_Conference  controlConference;
	public static  C_ConnexionUtilisateur uneConnexUtil ;
	public static C_ConferenceAction controlActionConf;
	public static C_Presentation contrpmPresentation;
	public static C_Erreur controlErreur;
	public static C_MenuSalle menuSalleControl;
	public static C_MenuSalleAction menuSalleActionControl;
	public static C_ManuAnimateur menuAnimateurControl;
	public static C_MenuAnimateurAction menuAnimateurActionControl;
	public static C_fihierAction fichierControl;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		M_GSB2.connexionBDD();
		System.out.println(M_GSB2.statPourcentageInscris(2));
		System.out.println(M_GSB2.statPourcentageInscrisStat(2,2));
		System.out.println(M_GSB2.statPourcentageInscrisStat(2,3));
		System.out.println(M_GSB2.statPourcentageInscrisStat(2,1));
		/*System.out.println(	M_GSB2.ConnectionUtilisateur("Test02","Test02"));
		System.out.println(	M_GSB2.getEmploiUtilisateur("Test02","Test02"));
		System.out.println(	M_GSB2.getEmploiUtilisateur("Test01","Test01"));*/
		
		// Instanciation de V_Frame
		
		controlConference   = new C_Conference() ;
		uneConnexUtil = new C_ConnexionUtilisateur ();
		contrpmPresentation = new C_Presentation();
		controlActionConf = new C_ConferenceAction();
		controlErreur = new C_Erreur ();
		menuSalleControl = new C_MenuSalle();
		menuSalleActionControl = new C_MenuSalleAction();
		menuAnimateurControl = new C_ManuAnimateur();
		menuAnimateurActionControl = new C_MenuAnimateurAction();
		fichierControl = new C_fihierAction();
		
		connexion = new V_Connexion(uneConnexUtil);
		menuePresentation = new  V_Presentat(controlConference);
		ajouterConference = new V_AjouterUneConference(controlActionConf);
		erreur = new V_Erreur(controlErreur);
		statPresntation = new V_StatPresentation(C_Conference.idConference,Main.contrpmPresentation);
		
		menuSalle = new  V_MenuSalle(menuSalleControl);
		
		afficherSalle = new  V_AfficherSalle();
		ajouterSalle = new  V_ajouterSalle( menuSalleActionControl);
		suprimerSalle = new V_supprimerSalle(menuSalleActionControl);
		
		tabMenuSallePanel = new JPanel[3];  
		tabMenuSallePanel[0] =afficherSalle;
		tabMenuSallePanel[1] =ajouterSalle;
		tabMenuSallePanel[2] =suprimerSalle ;
		
		menuAnimateur = new  V_MenueAnimateur(menuAnimateurControl);
		
		afficherAnimateur = new  V_AfficherAnimateur();
		ajouterAnimateur = new  V_AjouterAnimateur(menuAnimateurActionControl);
		suprimerAnimateur = new V_SupprimerAnimateur(menuAnimateurActionControl);
		
		tabMenuAnimateurPanel = new JPanel[3];
		tabMenuAnimateurPanel[0] =afficherAnimateur;
		tabMenuAnimateurPanel[1] =ajouterAnimateur;
		tabMenuAnimateurPanel[2] =suprimerAnimateur ;
		
		menuFichier = new  V_MenuFichier(fichierControl);
		fichierEnregister = new V_EnregisterFichier(fichierControl);
		lienFichier = new V_LienFichier(fichierControl);
		
		
		 
	
		
		 
		mainFrame = new V_Frame();
		M_GSB2.ajoutPanel(menuePresentation);
		
		M_GSB2.ajoutPanel( ajouterConference );
		M_GSB2.ajoutPanel(connexion);
		M_GSB2.ajoutPanel(erreur);
		
		M_GSB2.ajoutPanel(menuSalle);
		menuSalle.add(afficherSalle);
		menuSalle.add(ajouterSalle );
		menuSalle.add(suprimerSalle );
		
		M_GSB2.affichePanelTab(tabMenuSallePanel, 0);
		
		M_GSB2.ajoutPanel(menuAnimateur);
		menuAnimateur.add(afficherAnimateur);
		menuAnimateur.add(ajouterAnimateur );
		menuAnimateur.add(suprimerAnimateur );
		
		M_GSB2.affichePanelTab(tabMenuAnimateurPanel, 0);
		
		M_GSB2.ajoutPanel(menuFichier);
		M_GSB2.ajoutPanel(fichierEnregister);
		M_GSB2.ajoutPanel(lienFichier);
		
		M_GSB2.inviblePanel();
		connexion.setVisible(true);
	
		
		
		

	}

}