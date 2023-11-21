package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.CSV;
import Main.Main;
import Main.PDF;
import Main.XML;
import Modele.M_GSB2;

public class C_fihierAction  implements ActionListener {
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		switch(e.getActionCommand()){
		case "Sauvegarde":
			M_GSB2.inviblePanel();
			Main.fichierEnregister.setVisible(true);
			
		break;
		case"Lien":
			M_GSB2.inviblePanel();
			Main.lienFichier.setVisible(true);
		break;
		case "Selectionner":
			String path =Main.lienFichier.getFileChooser().getCurrentDirectory().getPath();
			M_GSB2.inviblePanel();
			Main.fichierEnregister.setVisible(true);
			Main.fichierEnregister.getLienFichierField().setText(path);
		break;
		case "Enregistrer":
			String chemin = Main.fichierEnregister.getLienFichierField().getText();
			String nomFichier = Main.fichierEnregister.getNomFichierField().getText();
			
			if(Main.fichierEnregister.getFormatTXT() == "PDF") {
				new PDF(chemin,nomFichier);
			}
			if(Main.fichierEnregister.getFormatTXT() == "CSV") {
				new CSV(chemin,nomFichier);
			}
			if(Main.fichierEnregister.getFormatTXT() == "XML") {
				new PDF(chemin,nomFichier);
			}
			M_GSB2.inviblePanel();
			Main.menuePresentation.setVisible(true);
			
			Main.menuSalle.setVisible(true);
			Main.menuAnimateur.setVisible(true);
			Main.menuFichier.setVisible(true);
			
			if (Main.toutesPresentation !=  null  ) {
				Main.toutesPresentation.setVisible(true);
			}
			
		break;
		case"Retour":
			M_GSB2.inviblePanel();
			Main.menuePresentation.setVisible(true);
			Main.menuSalle.setVisible(true);
			Main.menuAnimateur.setVisible(true);
			Main.menuFichier.setVisible(true);
			
			if (Main.toutesPresentation !=  null  ) {
				Main.toutesPresentation.setVisible(true);
			}
		break;
			
	}

}
}
