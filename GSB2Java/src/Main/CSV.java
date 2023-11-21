package Main;

import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Class.Conference;
import Class.Presentation;
import Modele.M_GSB2;

public class CSV {
	public CSV(String path,String nomFichier) {
        try {
            FileWriter writer = new FileWriter(path+"/"+nomFichier+".csv");
            
            ArrayList<Conference> listConference = M_GSB2.getLesConference();
            
        	for(Conference lesListConference : listConference  ) {
        		
        	
            
            writer.append("Conference : ");
            writer.append(',');
            writer.append(lesListConference.getTheme()+"          ");
            writer.append('\n');
            
            writer.append("Presentation                      ");
            writer.append('\n');
            
            writer.append("Date");
			writer.append(',');
			writer.append("Heure");
			writer.append(',');
			writer.append("Dur�e");
			writer.append(',');
			writer.append("Salle   ");
			writer.append(',');
			writer.append("NombeDePlace");
			writer.append('\n');
			
            ArrayList<Presentation> listPresentation = M_GSB2.getLesPresentation(lesListConference.getId());
        	
    		for(Presentation lesListPresentation : listPresentation  ) {
    			
    			
    			writer.append(lesListPresentation.getDatePlanning().toString());
    			writer.append(',');
    			writer.append(lesListPresentation.getHoraireDebut().toString());
    			writer.append(',');
    			writer.append(lesListPresentation.getDuree().toString());
    			writer.append(',');
    			writer.append(lesListPresentation.getSalle());
    			writer.append(',');
    			writer.append(String.valueOf(lesListPresentation.getNbPlaceDispo()));
    			writer.append('\n');
    			
    		}
    		writer.append('\n');
			writer.append('\n');
        	}
            
            
      

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
