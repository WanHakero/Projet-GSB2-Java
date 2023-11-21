package Vue;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controler.C_Presentation;
import Modele.M_GSB2;

public class V_StatPresentation extends JPanel{
	
	private JLabel tauxInscription;
	
	private JLabel tauxPresent;
	
	private JLabel tauxAbsent;
	
	private JButton btnRetour;
	
	
	public V_StatPresentation(int id,C_Presentation controler) {
		
		this.setBounds(0,70,500,180);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder( "Stat Presentation"));
		
		tauxInscription = new JLabel("Taux de d'inscription : " + M_GSB2.statPourcentageInscris(id) +"%  ("+M_GSB2.getNombreDeParticipant(id)+"/"+M_GSB2.getNombrePlaceSalle(id)+")");
		tauxInscription.setBounds(20, 50, 200, 30);
		 this.add( tauxInscription );
		 
		 tauxPresent = new JLabel("Taux de pressence : " + M_GSB2.statPourcentageInscrisStat(id, 2) +"%  ("+M_GSB2.getNombreDeParticipant(id, 2)+"/"+M_GSB2.getNombreDeParticipant(id)+")");
		 tauxPresent.setBounds(20, 80, 200, 30);
		 this.add( tauxPresent );
		 
		 tauxPresent= new JLabel("Taux d'absence : " + M_GSB2.statPourcentageInscrisStat(id, 3) +"%  ("+M_GSB2.getNombreDeParticipant(id, 3)+"/"+M_GSB2.getNombreDeParticipant(id)+")");
		 tauxPresent.setBounds(20, 110, 200, 30);
		 this.add( tauxPresent );
		 
		 btnRetour = new JButton("Retour");
		 btnRetour.setBounds(20, 20, 100, 30);
		 btnRetour.addActionListener(controler);
		 this.add(btnRetour);
		
		
	}

}
