package Vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Class.Salle;
import Controler.C_MenuSalleAction;
import Modele.M_GSB2;

public class V_supprimerSalle extends JPanel{
	
	private JLabel salleLab;
	private String[] listDeSalle;
	private JComboBox<String> listSalleBox;
	
	private JButton suprimerSalleButton;
	private JLabel info;
	
	public V_supprimerSalle(C_MenuSalleAction  control) {
		
		this.setBounds(0,50,285,250);
		
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder( "Salle"));
		
		recreer(control);
		
	}
	
	public void recreer(C_MenuSalleAction  control) {
		salleLab = new JLabel("Nom :");
		salleLab.setBounds(25, 25, 200, 30);
		this.add(salleLab);

		
		ArrayList<Salle> listSalle = M_GSB2.getLesSalle();
		int i = 0;
		listDeSalle = new String[listSalle.size()];
		
		for (Salle uneSalle :listSalle  ) {
			listDeSalle[i] = uneSalle.getNomSalle();
			i++;
		}
		
		listSalleBox = new JComboBox<>(listDeSalle);
		listSalleBox.setBounds(25, 60, 150, 30);
		this.add(listSalleBox);
		
		suprimerSalleButton = new JButton("Supprimer");
		suprimerSalleButton.setBounds(150, 100, 100, 30);
		suprimerSalleButton.addActionListener(control);
		this.add(suprimerSalleButton);
		
		info = new JLabel();
		info.setBounds(2, 212, 285, 40);
		info.setBorder(BorderFactory.createTitledBorder(""));
		this.add(info);
	}

	public String getTxtListSalleBox() {
		return this.listSalleBox.getItemAt(listSalleBox.getSelectedIndex());
	}

	public JLabel getInfo() {
		return info;
	}

	public void setInfoTXT(String uneInfo) {
		this.info.setText(uneInfo);
	}
}
