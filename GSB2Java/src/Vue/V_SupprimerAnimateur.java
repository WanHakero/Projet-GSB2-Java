package Vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Class.Animateur;
import Controler.C_ManuAnimateur;
import Controler.C_MenuAnimateurAction;
import Modele.M_GSB2;

public class V_SupprimerAnimateur extends JPanel {

	private JLabel AnimateurLab;
	private String[] listDeAnimateur;
	private int[] idDeAnimateur;
	private JComboBox<String> listAnimateurBox;
	
	private JButton suprimerAnimateurButton;
	private JLabel info;
	
	public V_SupprimerAnimateur(C_MenuAnimateurAction  control) {
		
		this.setBounds(0,50,285,250);
		
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder( "Animateur"));
		
		recreer(control);
		
	}
	
	public String getTxtlistDeAnimateur() {
		return this.listAnimateurBox.getItemAt(listAnimateurBox.getSelectedIndex());
	}
	
	public void recreer(C_MenuAnimateurAction control) {
		AnimateurLab = new JLabel("Nom :");
		AnimateurLab.setBounds(25, 25, 200, 30);
		this.add(AnimateurLab);

		
		ArrayList<Animateur> listAnimateur = M_GSB2.getLesAnimateur();
		int i = 0;
		listDeAnimateur = new String[listAnimateur.size()];
		idDeAnimateur = new int[listAnimateur.size()];
		for (Animateur uneAnimateur :listAnimateur  ) {
			listDeAnimateur[i] = uneAnimateur.getNom()+" "+uneAnimateur.getPrenom();
			idDeAnimateur[i] = uneAnimateur.getId();
			i++;
		}
		
		listAnimateurBox = new JComboBox<>(listDeAnimateur);
		listAnimateurBox.setBounds(25, 60, 150, 30);
		this.add(listAnimateurBox);
		
		suprimerAnimateurButton = new JButton("Supprimer");
		suprimerAnimateurButton.setBounds(150, 100, 100, 30);
		suprimerAnimateurButton.addActionListener(control);
		this.add(suprimerAnimateurButton);
		
		info = new JLabel();
		info.setBounds(2, 212, 285, 40);
		info.setBorder(BorderFactory.createTitledBorder(""));
		this.add(info);
	}
	
	public void setInfoTXT(String uneInfo) {
		info.setText(uneInfo);
	}
	
	public int getIdAnimateur() {
		return idDeAnimateur[listAnimateurBox.getSelectedIndex()];
	}
}

