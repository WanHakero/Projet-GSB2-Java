package Main;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Class.Conference;
import Class.Presentation;
import Modele.M_GSB2;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class PDF {

	public PDF (String path,String nomFichier) {
        try {
            // Create a new document
            Document document = new Document();

            // Create a new PdfWriter instance
            PdfWriter.getInstance(document, new FileOutputStream(path+"/"+nomFichier+".pdf"));

            // Open the document
            document.open();

            
            ArrayList<Conference> listConference = M_GSB2.getLesConference();
            
        	for(Conference lesListConference : listConference  ) {
        		
        	
            
            // Add a paragraph to the document
        	Paragraph para =new Paragraph(lesListConference.getTheme()+" : ");
           
        	

            // Add the underline chunk to the paragraph
            
            document.add(para);
            
            document.add(new Paragraph("\n"));
           
            
           

          
          
        	ArrayList<Presentation> listPresentation = M_GSB2.getLesPresentation(lesListConference.getId());
        	
    		for(Presentation lesListPresentation : listPresentation  ) {
    			
    				PdfPTable table = new PdfPTable(4);

    	            PdfPCell cell = new PdfPCell(new Phrase("Conferenre"));
    	            cell.setColspan(4);
    	            table.addCell(cell);
    	          
    	            table.addCell("Date ");
    				PdfPCell cell01 = new PdfPCell(new Phrase(lesListPresentation.getDatePlanning().toString()));
    				cell01 .setColspan(3);
     	            table.addCell(cell01);

    				table.addCell("Heure ");
    	            table.addCell(lesListPresentation.getHoraireDebut().toString());

    	            table.addCell("Durée ");
    	            table.addCell(lesListPresentation.getDuree().toString());
    	            
    	            table.addCell("Salle");
    	            table.addCell(lesListPresentation.getSalle());
    	            
    	            table.addCell("Nombre place");
    	            table.addCell(""+M_GSB2.getNombrePlaceSalle(lesListPresentation.getId()));
    	            
    	            table.addCell("Taux d'insctription");
    	        	PdfPCell cell02 = new PdfPCell(new Phrase(""+M_GSB2.statPourcentageInscris(lesListPresentation.getId())+"%"));
    				cell02 .setColspan(3);
     	            table.addCell(cell02);
     	            
     	            table.addCell("Taux de presence");
     	            table.addCell(""+M_GSB2.statPourcentageInscrisStat(lesListPresentation.getId(), 2)+"%");
     	            table.addCell("Taux d'absent");
     	            table.addCell(""+M_GSB2.statPourcentageInscrisStat(lesListPresentation.getId(), 3)+"%");
     	        
    	            
    	            
    	            document.add(table);
    		}
    		
    		 
    		  document.add(new Paragraph("\n\n"));
        	}

            // Add the table to the document
           
            // Close the document
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}