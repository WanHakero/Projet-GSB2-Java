package Vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

import Class.Conference;
import Class.Presentation;
import Controler.C_Conference;
import Controler.C_Presentation;
import Modele.M_GSB2;

public class V_Presentat  extends JPanel{
	
	private JButton btnAjouterConference ;
	private JButton btnSelectioner;
	private JButton btnSuppimer;
	
	//Liste deroulante de Conference
	private String[] listDeConference;
	private JComboBox<String> listConference;
	private int[] listId;

	public  V_Presentat( C_Conference  controleur) {
		
		this.setBounds(0,0,800,70);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder( "Conference"));
		
		this.btnSelectioner = new JButton("Selectioner");
		this.btnSelectioner.setBounds(200,20,100,35);
		this.btnSelectioner.addActionListener(controleur);
		this.add(btnSelectioner );

		
		this. btnAjouterConference = new JButton("Ajouter");
		this. btnAjouterConference.setBounds(600,20,150,35);
		this.btnAjouterConference.addActionListener(controleur);
		this.add( btnAjouterConference);
		
		this. btnSuppimer = new JButton("Supprimer");
		this. btnSuppimer.setBounds(310,20,100,35);
		this.btnSuppimer.addActionListener(controleur);
		this.add( btnSuppimer);
		
		
		ArrayList<Conference> tabP = M_GSB2.getLesConference();
		listDeConference = new String[tabP.size()];
		listId = new int[tabP.size()];
		for(int i = 0;i < tabP.size() ; i++) {
			this.listDeConference[i]= tabP.get(i).getTheme();
			this.listId[i] = tabP.get(i).getId();
			
		}
		
		this.listConference = new JComboBox<>(listDeConference);
		this.listConference.setBounds(10,25,180,25);
		this.add(listConference);
		
		
		this.setVisible(true);
		
		
	}
	public void estReponsable() {
		this.btnAjouterConference.setVisible(false);
		this.btnSuppimer.setVisible(false);
	}
	
	
	public String getTxtListConference() {
		return this.listConference.getItemAt(listConference.getSelectedIndex());
	}
	public int getIDListConference() {
		return this.listId[listConference.getSelectedIndex()];
		///
	}

}
