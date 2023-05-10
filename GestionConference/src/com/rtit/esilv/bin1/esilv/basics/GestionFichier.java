/* Import(s) & Package(s) */
package com.rtit.esilv.bin1.esilv.basics;

import com.rtit.esilv.bin1.esilv.dao.PresentationDAO;
import com.rtit.esilv.bin1.esilv.dao.SessionDAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author User RTIT
 *
 * Classe de gestion des Fichiers
**/
public class GestionFichier {
    /* Method(s) */
    /* Method: writeFile */
    /* Purpose: Write a file based on a Conference object */
    /**
     * @param conf - format: Conference object
    **/
    public static void writeFile(Conference conf) {
        // Variable(s)
        String extension = ".txt";
        String fileName = conf.getNom().toLowerCase() + Integer.toString(conf.getAnnee()).toLowerCase() + extension;

        // Write file (try-catch)
        try {
            // Variable(s)
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);

            // Object(s) attributes
            String conf_Name = conf.getNom();
            String conf_Place = conf.getLieu();
            int conf_Year = conf.getAnnee();

            // Write conferences informations
            fw.write("Nom de la conférence: " + conf_Name + "\n");
            fw.write("Lieu de la conférence: " + conf_Place + "\n");
            fw.write("Année de la conférence: " + conf_Year + "\n");

            // Check if the conference is online
            if(conf.getLieu().equals("online")) {
                ConferenceOnline confOnline = (ConferenceOnline) conf; // Cast the Conference object to a ConferenceOnline object
                fw.write("URL de la conférence: " + confOnline.getUrl() + "\n");
                fw.write("Mot de passe de la conférence: " + confOnline.getPassword() + "\n");
            }

            // Write every sessions and presentations
            for(Session session : SessionDAO.getAllSessionsByID(conf.getId())) {
                // Write session informations
                fw.write("\nSession sur " + session.getSpecialite() + " le " + session.getJour() + "/" + session.getMois() + "\n");

                // Write every presentations
                for(Presentation presentation : PresentationDAO.getAllPresentationsByID(session.getId())) {
                    fw.write("\t" + presentation.toString() + "\n");
                }
            }

            // Close the file & confirm the writing
            fw.close();
            System.out.println("Fichier " + fileName + " créé avec succès ! (" + file.getAbsolutePath() + ")");
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
