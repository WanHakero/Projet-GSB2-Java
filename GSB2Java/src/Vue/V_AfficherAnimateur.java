package Vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Class.Animateur;
import Controler.C_MenuAnimateurAction;
import Modele.M_GSB2;

public class V_AfficherAnimateur extends JPanel{

	private JTable tabAnimateur;
	private Object[][] donneAnimateur;
	private String[] headAnimateur;
	private JScrollPane table;
	
	public  V_AfficherAnimateur () {
	
this.setBounds(0,50,285,250);
		
	this.setBackground(Color.white);
	this.setLayout(null);
	this.setBorder(BorderFactory.createTitledBorder( "Animateur"));
	
	 recreer();
			
	}
	
	public void recreer() {
		
	this.headAnimateur = new String[2];
	this.headAnimateur[0] = "Nom";
	this.headAnimateur[1] = "Prenom";
	
	ArrayList<Animateur> listAnimateur = M_GSB2.getLesAnimateur();
	
	this.donneAnimateur = new Object[listAnimateur.size()][4];
	int i = 0;
	for(Animateur uneAnimateur : listAnimateur ) {
		this.donneAnimateur[i][0]= uneAnimateur.getNom();
		this.donneAnimateur[i][1]= uneAnimateur.getPrenom();
		i++;
	}
	
	this.tabAnimateur = new JTable(this.donneAnimateur,this.headAnimateur);
	
	table = new JScrollPane(tabAnimateur);
	table.setBounds(25, 20, 240,200);
	this.add(table);
	}
}

