package Modele;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.xml.crypto.Data;

import Class.Animateur;
import Class.Conference;

import Class.Presentation;
import Class.Salle;

import Main.Main;

public class M_GSB2 {
	
	static  Connection connexion;
	static  Statement st;
	static 	ResultSet rs ;
	static PreparedStatement pst;
	static ArrayList<JPanel> tabPanel;
	
	//------- Connexion base de donn� -------
	static public Connection connexionBDD() {
		tabPanel = new  ArrayList<JPanel>();
		String ipBDD ;
			ipBDD ="172.16.203.206/GSB2";
			//ipBDD ="172.16.203.205/GSB2";
			//ipBDD =	"127.0.0.1/gsb2";
			//ipBDD =	"localhost/gsb2";

		
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		connexion = DriverManager.getConnection("jdbc:mysql://"+ipBDD+"?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "sio","Slam123456");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur de chargement de pilote");
		}catch (SQLException e2) {
			System.out.println("Erreur de connexion de base de donn�:"+e2);
		}
		return connexion;
		}
	
	
	
	static public void deconnexionBDD() {
		try {
			connexionBDD().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreu deco");
		}
	}
	
	
		//------- Connexion utilisateur -------
	/**
	 * Cette procedure permetra de connecter en tant qu'utilisateur
	 * @param loginUser
	 * @param mdpUser
	 * @return
	 */
		static public boolean ConnectionUtilisateur(String loginUser,String mdpUser) {
			
			 String requete ="SELECT COUNT(idUtilisateur) AS nbId FROM Utilisateur WHERE login = ? AND mdp = ?";
			
			 boolean res = false;
			 int nbID = 0;
			 try {
				 pst = connexion.prepareStatement(requete);
				 pst.setString(1, loginUser);
				 pst.setString(2, mdpUser);
				 
			
				
				 
				 rs = pst.executeQuery();
				 if (rs.next()) {
					 nbID =rs.getInt("nbId");
				 }
			} catch (SQLException e) {
				System.out.println("Erreur connexion user :"+e); 
			}
			 
			 if(nbID == 1) {
				 res = true;
				
			 }
			 return res;
			
		}
		
		/**
		 * Cette fonction recupera le poste d'utilisateur et sera utiliser pour savoir si c'est utilisateur est assigner a ce poset
		 * @param loginUser
		 * @param mdpUser
		 * @return String emploi
		 */
		static public String getEmploiUtilisateur(String loginUser,String mdpUser) {
			String requete ="Select nomFonction FROM Emploi F,Utilisateur U WHERE F.idFonction = U.idUtilisateur AND login = '"+loginUser+"' AND mdp ='"+mdpUser+"'";
	
			String emploi = null;
			
			 try {
			pst = connexion.prepareStatement(requete);
			 rs = pst.executeQuery();
			 if (rs.next()) {
				 emploi =rs.getString(1);  
			 }
		} catch (SQLException e) {
			System.out.println("Erreur SQL :"+e); 
		}

		 return emploi;
			
		}
		
		static public int getEmploiUtilisateurID(String loginUser,String mdpUser) {
			String requete ="Select fonction FROM Utilisateur WHERE login = '"+loginUser+"' AND mdp ='"+mdpUser+"'";
	
			int id = 0;
			
			 try {
			pst = connexion.prepareStatement(requete);
			 rs = pst.executeQuery();
			 if (rs.next()) {
				 id  =rs.getInt(1);  
			 }
		} catch (SQLException e) {
			System.out.println("Erreur SQL :"+e); 
		}

		 return  id ;
			
		}
//-----------------------------------------------------------------------------
		
		/**
		 * R�cup�re dans la base de donn�es toutes les conf�rences et les renvoie.
		 * @return ArrayList<Conference>
		 */
		static	public ArrayList<Conference> getLesConference(){
			String requete ="SELECT idConference,theme FROM Conference";
			ArrayList<Conference> list = new ArrayList<Conference>();
			
			String unTheme;
		
			int id ;
			
			
			try {
				st =  connexion.createStatement();
				rs = st.executeQuery(requete);
				while(rs.next()) {
			
				id = rs.getInt(1);
				unTheme = rs.getString(2);
				
				Conference  uneConference = new Conference(id,unTheme);
				list.add(uneConference);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur SQL : " +e);
			}
			
			return list;
		}
		
		
		/**
		 * Permet de cr�er une nouvelle conf�rence
		 * @param theme
		 * @return  bool�en en fonction de la r�ussite ou l"�chec de la fonction
		 */
		static	public boolean creerUneConference(String theme) {
			String requete ="INSERT INTO Conference (theme) VALUES ('"+theme+"')";
			
			boolean res =  false;
			int count = 0;
			 try {
				st = connexion.createStatement();
				count = st.executeUpdate(requete);
				
				System.out.println("Ligne ajouter: "+count);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				res = false;
				System.out.println("Erreur : " +e);
			}
			if (count == 1) {
				res = true;
			}
			return res;
		}
		
		
		
		
		
		/**
		 * Supprime une conf�rence de la liste de conf�rences : ListConference
		 * @param theme
		 * @return  bool�en en fonction de la r�ussite ou l"�chec de la fonction
		 */
		static	public boolean SupprimerUneConference(int id) {
			String requete ="DELETE FROM Conference Where idConference = '"+id+"' ";
			
			boolean res =  false;
			int count = 0;
			 try {
				st = connexion.createStatement();
				count = st.executeUpdate(requete);
				
				System.out.println("Ligne ajouter: "+count);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				res = false;
				System.out.println("Erreur : " +e);
			}
			if (count == 1) {
				res = true;
			}
			return res;
		}
		
		static	public boolean SupprimerUnePresentationConference(int id) {
			String requete ="DELETE FROM  ListeDePrestation Where conference = '"+id+"' ";
			
			boolean res =  false;
			int count = 0;
			 try {
				st = connexion.createStatement();
				count = st.executeUpdate(requete);
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				res = false;
				System.out.println("Erreur : " +e);
			}
			if (count == 1) {
				res = true;
			}
			return res;
		}
		

		
		
		
//---------------------------------------------------------------------------------------
		/**
		 * Recup�re toutes les information des salle de la base de donn�e
		 * @return ArrayList<Salle> listSalle
		 */
		static	public ArrayList<Salle> getLesSalle(){
			String requete ="SELECT nomSalle,nbPlaceMax FROM Salle";
			ArrayList<Salle> listSalle = new ArrayList<Salle>();
			String unNom;
			int nbPlace;
			
			
			try {
				st =  connexion.createStatement();
				rs = st.executeQuery(requete);
				while(rs.next()) {
				unNom = rs.getString(1);
				nbPlace = rs.getInt(2);
				Salle  uneSalle  = new Salle(unNom,nbPlace);
				listSalle.add(uneSalle);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur SQL : " +e);
			}
			
			return listSalle;
		}
		
		static	public boolean creerUneSalle(Salle uneSalle) {
			String requete ="INSERT INTO Salle (nomSalle,nbPlaceMax) VALUES ('"+uneSalle.getNomSalle()+"','"+uneSalle.getNbPlaceMax()+"')";
			
			boolean res =  false;
			int count = 0;
			 try {
				st = connexion.createStatement();
				count = st.executeUpdate(requete);
				
				System.out.println("Ligne ajouter: "+count);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				res = false;
				System.out.println("Erreur : " +e);
			}
			if (count == 1) {
				res = true;
			}
			return res;
		}
		
		static	public boolean SupprimerUneSalle(String uneSalle) {
			String requete ="DELETE FROM  Salle Where nomSalle = '"+uneSalle+"' ";
			
			boolean res =  false;
			int count = 0;
			 try {
				st = connexion.createStatement();
				count = st.executeUpdate(requete);
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				res = false;
				System.out.println("Erreur : " +e);
			}
			if (count == 1) {
				res = true;
			}
			return res;
		}
		
		
		/**
		 * Recup�re toutes les information des Animateurde la base de donn�e
		 * @return ArrayList<Animateur> listAnimateur
		 */
		static	public ArrayList<Animateur> getLesAnimateur(){
			String requete ="SELECT idAnimateur,nom,prenom FROM Animateur";
			ArrayList<Animateur> list = new ArrayList<Animateur>();
			
			String unPrenom;
			String unNom;
			int id ;
			
			
			try {
				st =  connexion.createStatement();
				rs = st.executeQuery(requete);
				while(rs.next()) {
					
				id = rs.getInt(1);
				unNom = rs.getString(2);
				unPrenom = rs.getString(3);
				Animateur  unAnimateur  = new Animateur(id,unNom,unPrenom);
				list.add(unAnimateur);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur SQL : " +e);
			}
			
			return list;
		}
		static	public boolean creerUnAnimateure(Animateur unAnimateur) {
			String requete ="INSERT INTO Animateur(nom,prenom) VALUES ('"+unAnimateur.getNom()+"','"+unAnimateur.getPrenom()+"')";
			
			boolean res =  false;
			int count = 0;
			 try {
				st = connexion.createStatement();
				count = st.executeUpdate(requete);
				
				System.out.println("Ligne ajouter: "+count);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				res = false;
				System.out.println("Erreur : " +e);
			}
			if (count == 1) {
				res = true;
			}
			return res;
		}
		
		static	public boolean SupprimerUnAnimateure(int id) {
			String requete ="DELETE FROM  Animateur Where idAnimateur = '"+id+"' ";
			
			boolean res =  false;
			int count = 0;
			 try {
				st = connexion.createStatement();
				count = st.executeUpdate(requete);
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				res = false;
				System.out.println("Erreur : " +e);
			}
			if (count == 1) {
				res = true;
			}
			return res;
		}
		
		/**
		 * Permet de cr�er une nouvelle conf�rence
		 * @param uneConference
		 * @return  bool�en en fonction de la r�ussite ou l"�chec de la fonction
		 */
		static	public boolean creerUneConference(Conference uneConference){
			String requete ="INSERT INTO Conference (theme) VALUES ('"+uneConference.getTheme()+"');";
			
			boolean res =  false;
			int count = 0;
			 try {
				st = connexion.createStatement();
				count = st.executeUpdate(requete);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				res = false;
				System.out.println("Erreur : " +e);
			}
			if (count == 1) {
				res = true;
			}
			return res;
		}
			
		
/**
 * R�cup�re les presentation d'une conference
 * @param conference
 * @return  ArrayList<Presentation> 
 */
		static	public ArrayList<Presentation> getLesPresentation(int conference ){
			String requete ="SELECT idPresentation,duree,nbPlaceDispo,Salle,Animateur,Date,Heure FROM Presentation P,ListeDePrestation LDP WHERE P.idPresentation = LDP.presentation AND conference = "+conference+"";
			ArrayList<Presentation> list = new ArrayList<Presentation>();
			
			
			int id ;
			Time duree;
			int nbPlaceDispo;
			
			String salle;
			int Animateur;
			Date uneDate;
			Time uneHeure;
			
			
			
			
			try {
				st =  connexion.createStatement();
				rs = st.executeQuery(requete);
				while(rs.next()) {
					
				id = rs.getInt(1);
				duree = rs.getTime(2);
				nbPlaceDispo = rs.getInt(3);
				salle  = rs.getString(4);
				Animateur  = rs.getInt(5);
				uneDate = rs.getDate(6);
				uneHeure = rs.getTime(7);
				
				Presentation  unePresentation = new Presentation(id,duree,nbPlaceDispo,uneDate,uneHeure,salle,Animateur);
				list.add(unePresentation);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur SQL : " +e);
			}
			
			return list;
		}
		
		
		/**
		 * Permet d'ajouter une pr�sentation dans la liste 
		 * @param unePresentation
		 * @return bool�en en fonction de la r�ussite ou l"�chec de la fonction
		 */
		static public boolean ajouterUnePresentation(Presentation unePresentation) {
			
			
			Time duree  = unePresentation.getDuree();
			int nbPlaceDispo = unePresentation.getNbPlaceDispo();
	
			
			String requete = "INSERT INTO Presentation (duree,nbPlaceDispo) VALUE ('"+duree+"','"+nbPlaceDispo+"')";
			boolean res =  false;
			int count = 0;
			 try {
				st = connexion.createStatement();
				count = st.executeUpdate(requete);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				res = false;
				System.out.println("Erreur : " +e);
			}
			if (count == 1) {
				res = true;
			}
			return res;
		}
		
		/**
		 * Suppirmer une presentation dans la base de don�e
		 * @param id
		 * @return  boolean
		 */
		static public boolean supprimerUnePresentation(int id) {
			
			String requete = "DELETE FROM Presentation WHERE idPresentation = '"+id+"'";
			boolean res =  false;
			int count = 0;
			 try {
				st = connexion.createStatement();
				
				count = st.executeUpdate(requete);
				System.out.println(requete);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				res = false;
				System.out.println("Erreur : " +e);
			}
			if (count == 1) {
				res = true;
			}
			return res;
		}
		/**
		 * Suppirmer une presentation dans la base de don�e
		 * @param idP
		 * @param idC
		 * @return
		 */
		static public boolean supprimerUnePresentationDansLaListe(int idP) {
			
			String requete = "DELETE FROM ListeDePrestation WHERE presentation = '"+idP+"'";
			
			boolean res =  false;
			int count = 0;
			 try {
				st = connexion.createStatement();
				count = st.executeUpdate(requete);
				System.out.println(requete);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				res = false;
				System.out.println("Erreur : " +e);
			}
			if (count == 1) {
				res = true;
			}
			return res;
		}
		
		

		
	
	/**
	 * Ajoute un nouveau Panel
	 * @param panel
	 */
	public static  void ajoutPanel(JPanel panel) {
		Main.mainFrame.add(panel);
		tabPanel.add(panel);
	}
	
	
	/**
	 * Permet d'afficher un panel pass� en param�tre
	 * @param panel
	 */
	public static void inviblePanel() {
		
		for(JPanel listPanel : tabPanel  ) {
			listPanel.setVisible(false);
		}
		
	}


	public static void affichePanelTab(JPanel[] tabPanel , int p) {
		
		for(int i = 0; i< 3 ; i++) {
			tabPanel[i].setVisible(false);
		}
		tabPanel[p].setVisible(true);
	}
	

	static	public int getNombreDeParticipant(int presentation ){
		String requete ="SELECT COUNT(Visiteur) as nb FROM Inscription WHERE Presentation ='"+presentation+"';";
		int nb =0;
		try {
			st =  connexion.createStatement();
			rs = st.executeQuery(requete);
			if(rs.next()) {
				
			nb = rs.getInt(1);
			
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur SQL : " +e);
		}
		
		return nb;
	}
	
	static	public int getNombreDeParticipant(int presentation,int statut ){
		String requete ="SELECT COUNT(Visiteur) as nb FROM Inscription WHERE Presentation ='"+presentation+"' AND Status ='"+statut+"';";
		int nb =0;
		try {
			st =  connexion.createStatement();
			rs = st.executeQuery(requete);
			if(rs.next()) {
				
			nb = rs.getInt(1);
			
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur SQL : " +e);
		}
		
		return nb;
	}
	static	public int getNombrePlaceSalle(int presentation ){
		String requete ="SELECT nbPlaceMax FROM Salle S, Presentation P WHERE nomSalle = Salle AND idPresentation ='"+presentation+"'";
		int nb =0;
		try {
			st =  connexion.createStatement();
			rs = st.executeQuery(requete);
			if(rs.next()) {
				
			nb = rs.getInt(1);
			
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur SQL : " +e);
		}
		
		return nb;
	}
	
	
	
	static	public double statPourcentageInscris(int presentation ) {
		double stat = 0;
		int nbParticipant = getNombreDeParticipant( presentation );
		int nombrePlace = getNombrePlaceSalle( presentation );
		
		if(nbParticipant != 0) {
		stat =   (nbParticipant*100 /nombrePlace) ;
		}
		return stat;
	}
	static	public double statPourcentageInscrisStat(int presentation ,int status) {
		int nbParticipant = getNombreDeParticipant( presentation );
		double stat = 0;
		if(nbParticipant != 0) {
			int nbAbsent = getNombreDeParticipant( presentation,status);
			stat =   (nbAbsent*100/nbParticipant) ;
		}
		
		return stat;
	}
	
	
}


