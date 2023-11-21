package Vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Class.Salle;
import Modele.M_GSB2;

public class V_AfficherSalle extends JPanel{

	
	private JTable tabSalle;
	private Object[][] donneSalle;
	private String[] headSalle;
	private JScrollPane table;
	
	public V_AfficherSalle() {
		
		this.setBounds(0,50,285,250);
		
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder( "Salle"));
		
		recreer();
	
}
	public void recreer() {
		
		this.headSalle = new String[2];
		this.headSalle[0] = "Salle";
		this.headSalle[1] = "Place";
		
		ArrayList<Salle> listSalle = M_GSB2.getLesSalle();
		
		this.donneSalle = new Object[listSalle.size()][4];
		int i = 0;
		for(Salle uneSalle : listSalle ) {
			this.donneSalle[i][0]= uneSalle.getNomSalle();
			this.donneSalle[i][1]= uneSalle.getNbPlaceMax();
			i++;
		}
		
		this.tabSalle = new JTable(this.donneSalle,this.headSalle);
		
		table = new JScrollPane(tabSalle);
		table.setBounds(25, 20, 240,200);
		this.add(table);
		
	}
}
