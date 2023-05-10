/* Import(s) & Package(s) */
package com.rtit.esilv.bin1.esilv.dao;

import com.rtit.esilv.bin1.esilv.basics.Presentation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User RTIT
 *
 * Classe Database
**/
public class PresentationDAO {
    /* Method(s) */
    /* Method: getAllPresentations */
    /* Purpose: Get all presentations from database */
    /**
     * @return the ResultSet
     * @throws SQLException if there's an SQL error
    **/
    public static ArrayList<Presentation> getAllPresentations() throws SQLException {
        // Variable(s)
        String request = "SELECT * FROM presentation;";
        ResultSet result = Database.query(request);
        ArrayList<Presentation> collection = new ArrayList<>();

        // Loop through the result
        while(result.next()) {
            // Attribute(s)
            int id = result.getInt("id");
            String auteurs = result.getString("auteurs");
            String titreArticle = result.getString("titreArticle");
            int mois = result.getInt("mois");
            int jour = result.getInt("jour");
            String heure = result.getString("heure");

            // Create the session
            Presentation presentation = new Presentation(id, auteurs, titreArticle, mois, jour, heure);

            // Add the session to the collection
            collection.add(presentation);
        }

        // Close & return
        result.close();
        return collection;
    }

    /* Method: getPresentationByID */
    /* Purpose: Get a presentation by its ID */
    /**
     * @param id the presentation ID
     * @return the ResultSet
     * @throws SQLException if there's an SQL error
    **/
    public static Presentation getPresentationByID(int id) throws SQLException {
        // Variable(s)
        String request = "SELECT * FROM presentation WHERE id = " + id + ";";
        ResultSet result = Database.query(request);
        Presentation presentation = null;

        // Loop through the result
        if(result.next()) {
            // Attribute(s)
            String auteurs = result.getString("auteurs");
            String titreArticle = result.getString("titreArticle");
            int mois = result.getInt("mois");
            int jour = result.getInt("jour");
            String heure = result.getString("heure");

            // Create the session
            presentation = new Presentation(auteurs, titreArticle, mois, jour, heure);
        }

        // Close & return
        result.close();
        return presentation;
    }

    /* Method: addPresentation */
    /* Purpose: Add a presentation */
    /**
     * @param presentation the presentation to add
     * @throws SQLException if there's an SQL error
    **/
    public static void addPresentation(Presentation presentation) throws SQLException {
        // Variable(s)
        String lastSessionID = "SELECT MAX(id) FROM session ORDER BY id DESC LIMIT 1;";
        ResultSet result = Database.query(lastSessionID);
        int id;

        // Get the last ID
        if(result.next()) { id = result.getInt("MAX(id)"); }
        else {
            System.out.println("Erreur lors de la création d'une présentation.");
            System.out.println("Aucune conférence n'a été trouvée.");
            return;
        }

        // Create the request
        String request = "INSERT INTO presentation (auteurs, titreArticle, mois, jour, heure, id_session) VALUES (\""
                + presentation.getAuteurs() + "\", \""
                + presentation.getTitreArticle() + "\", "
                + presentation.getMois() + ", "
                + presentation.getJour() + ", \""
                + presentation.getHeure() + "\", "
                + id + ");";

        // Execute the request
        Database.execute(request);
    }

    /* Method: getSessionsAmount */
    /* Purpose: Get the amount of sessions based on the conference ID */
    /**
     * @param id the conference ID
     * @return the ResultSet
     * @throws SQLException if there's an SQL error
    **/
    public static ArrayList<Presentation> getAllPresentationsByID(int id) throws SQLException {
        // Variable(s)
        String request = "SELECT * FROM presentation WHERE id_session = " + id + ";";
        ResultSet result = Database.query(request);
        ArrayList<Presentation> collection = new ArrayList<>();
        Presentation presentation;

        // Loop through the result
        while(result.next()) {
            // Attribute(s)
            String auteurs = result.getString("auteurs");
            String titreArticle = result.getString("titreArticle");
            int mois = result.getInt("mois");
            int jour = result.getInt("jour");
            String heure = result.getString("heure");
            int id_session = result.getInt("id_session");

            // Create the session
            presentation = new Presentation(auteurs, titreArticle, mois, jour, heure, id_session);

            // Add the session to the collection
            collection.add(presentation);
        }

        // Close & return
        result.close();
        return collection;
    }
}
