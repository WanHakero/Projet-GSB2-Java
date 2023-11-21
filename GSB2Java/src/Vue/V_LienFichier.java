package Vue;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

import Controler.C_fihierAction;

public class V_LienFichier extends JPanel{
	private JButton btnSelectioner;
	private JFileChooser fileChooser;
	
	

	public  V_LienFichier(C_fihierAction control) {

	this.setBounds(0,0,400,400);
	this.setBackground(Color.white);
	this.setLayout(null);
	this.setBorder(BorderFactory.createTitledBorder( "Sauvegarde"));
	
	fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	fileChooser.setDialogTitle("Enregistrez le fichier");
	fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	btnSelectioner = new JButton("Selectionner");
	
	btnSelectioner.setBounds(110,373, 110, 27);
	btnSelectioner.addActionListener(control);
	this.add(btnSelectioner);

	fileChooser.setBounds(0,10,400,400);
	this.add(fileChooser);
	}
	
	public JButton getBtnSelectioner() {
		return btnSelectioner;
	}

	public void setBtnSelectioner(JButton btnSelectioner) {
		this.btnSelectioner = btnSelectioner;
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}
}
