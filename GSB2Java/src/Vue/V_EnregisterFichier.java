package Vue;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import Controler.C_fihierAction;

public class V_EnregisterFichier extends JPanel{

	JLabel nomFichierLab;
	JTextField nomFichierField;
	JLabel lienFichierLab;
	JTextField lienFichierField;
	
	JButton btnLien;
	JButton btnEnregistrer;
	JButton btnRetour;
	
	JLabel typeFichier;
	String[] listFormat;
	JComboBox<String> boxFormat;
			
	public V_EnregisterFichier(C_fihierAction control) {
		
		
		this.setBounds(0,0,400,250);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder( "Sauvegarde"));
		
		nomFichierLab = new JLabel("Nom du fichier : ");
		nomFichierLab.setBounds(20,40,100,30);
		this.add(nomFichierLab);
		
		nomFichierField = new JTextField("fichier");
		nomFichierField.setBounds(20,70,300,30);
		this.add(nomFichierField);
		
		lienFichierLab = new JLabel("Lien du fichier : ");
		lienFichierLab.setBounds(20,100,100,30);
		this.add(lienFichierLab);
		
		lienFichierField = new JTextField(FileSystemView.getFileSystemView().getDefaultDirectory().getPath());
		lienFichierField.setBounds(20,130,300,30);
		this.add(lienFichierField);
		
		
		btnLien = new JButton("Lien");
		btnLien.setBounds(320,130,60,30);
		btnLien.addActionListener(control);
		this.add(btnLien);
		
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBounds(250,200,100,30);
		btnEnregistrer.addActionListener(control);
		this.add(btnEnregistrer );
		
		btnRetour  = new JButton("Retour");
		btnRetour.setBounds(50,200,100,30);
		btnRetour.addActionListener(control);
		this.add(btnRetour );
		
		typeFichier = new JLabel("Format :");
		typeFichier .setBounds(20,20,100,20);
		this.add(typeFichier);
		
		
		listFormat = new String[3];
		listFormat[0] = "PDF";
		listFormat[1] = "CSV";
		listFormat[2] = "XML";
		
		boxFormat = new JComboBox<>(listFormat);
		boxFormat.setBounds(80,20,100,20);
		this.add(boxFormat);
		
		
		
		
		
	}

	public JTextField getNomFichierField() {
		return nomFichierField;
	}

	public void setNomFichierField(JTextField nomFichierField) {
		this.nomFichierField = nomFichierField;
	}

	public JTextField getLienFichierField() {
		return lienFichierField;
	}

	public void setLienFichierField(JTextField lienFichierField) {
		this.lienFichierField = lienFichierField;
	}
	public String getFormatTXT() {
		return this.boxFormat.getItemAt(boxFormat.getSelectedIndex());
	}
	
}
