/* Import(s) & Package(s) */
package com.rtit.esilv.bin1.esilv.dao;

import com.rtit.esilv.bin1.esilv.basics.Conference;
import com.rtit.esilv.bin1.esilv.basics.ConferenceOnline;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User RTIT
 *
 * Classe Database
**/
public class ConferenceDAO {
    /* Method(s) */
    /* Method: getAllSessions */
    /* Purpose: Get all sessions from database */
    /**
     * @return the ResultSet
     * @throws SQLException if there's an SQL error
    **/
    public static ArrayList<Conference> getAllConferences() throws SQLException {
        // Variable(s)
        String request = "SELECT * FROM conference;";
        ResultSet result = Database.query(request);
        ArrayList<Conference> collection = new ArrayList<>();

        // Loop through the result
        while(result.next()) {
            // Attribute(s)
            int id = result.getInt("id");
            String nom = result.getString("nom");
            String lieu = result.getString("lieu");
            int annee = result.getInt("annee");

            // Check if the conference is online
            Conference conference = result.getInt("is_online") == 1
                ? new ConferenceOnline(id, nom, annee, result.getString("password")) // If online
                : new Conference(id, nom, lieu, annee); // If not online

            // Add the conference to the collection
            collection.add(conference);
        }

        // Close & return
        result.close();
        return collection;
    }

    /* Method: getAllOnlineConferences */
    /* Purpose: Get all online conferences from database */
    /**
     * @return the ResultSet
     * @throws SQLException if there's an SQL error
    **/
    public static ArrayList<Conference> getAllOnlineConferences() throws SQLException {
        // Variable(s)
        String request = "SELECT * FROM conference WHERE is_online = 1;";
        ResultSet result = Database.query(request);
        ArrayList<Conference> collection = new ArrayList<>();

        // Loop through the result
        while(result.next()) {
            // Attribute(s)
            String nom = result.getString("nom");
            int annee = result.getInt("annee");
            String password = result.getString("password");

            // Check if the conference is online
            collection.add(new ConferenceOnline(nom, annee, password));
        }

        // Close & return
        result.close();
        return collection;
    }

    /* Method: getConferenceByID */
    /* Purpose: Get a conference by its ID */
    /**
     * @param id - format: int
     * @return the ResultSet
     * @throws SQLException if there's an SQL error
    **/
    public static Conference getConferenceByID(int id) throws SQLException {
        // Variable(s)
        String request = "SELECT * FROM conference WHERE id = " + id + ";";
        ResultSet result = Database.query(request);
        Conference conference = null;

        // Loop through the result
        if(result.next()) {
            // Attribute(s)
            int found_id = result.getInt("id");
            String nom = result.getString("nom");
            String lieu = result.getString("lieu");
            int annee = result.getInt("annee");

            // Check if the conference is online
            conference = result.getInt("is_online") == 1
                ? new ConferenceOnline(found_id, nom, annee, result.getString("password")) // If online
                : new Conference(found_id, nom, lieu, annee); // If not online
        }

        // Close & return
        result.close();
        return conference;
    }

    /* Method: addConference */
    /* Purpose: Add a conference */
    /**
     * @param conference - format: Conference
     * @throws SQLException if there's an SQL error
    **/
    public static void addConference(Conference conference) throws SQLException {
        // Variable(s)
        String request = "INSERT INTO conference (nom, lieu, annee, url, password, is_online) VALUES ("
            + "\"" + conference.getNom() + "\", "
            + "\"" + conference.getLieu() + "\", "
            + conference.getAnnee() + ", "
            + (conference instanceof ConferenceOnline ? "\"" + ((ConferenceOnline) conference).getUrl() + "\"" : "NULL") + ", "
            + (conference instanceof ConferenceOnline ? "\"" + ((ConferenceOnline) conference).getPassword() + "\"" : "NULL") + ", "
            + (conference instanceof ConferenceOnline ? 1 : 0)
            + ");";

        // Execute the request
        Database.execute(request);
    }
}
