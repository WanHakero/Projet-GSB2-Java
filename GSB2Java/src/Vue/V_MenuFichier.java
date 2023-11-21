package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

import Controler.C_fihierAction;

public class V_MenuFichier extends JPanel  {
	
	
	private JButton sauvegarde;
	
	public V_MenuFichier(C_fihierAction  control) {
		
	this.setBounds(500,670,285,90);
	this.setBackground(Color.white);
	this.setLayout(null);
	this.setBorder(BorderFactory.createTitledBorder( "Fichier"));
	
	sauvegarde = new JButton("Sauvegarde");
	sauvegarde.setBounds(75, 30, 150, 30);
	sauvegarde.addActionListener(control);
	this.add(sauvegarde);
	


	}

		
	
}
