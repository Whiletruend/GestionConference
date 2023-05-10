/* Import(s) & Package(s) */
package com.rtit.esilv.bin1.esilv.dao;

import com.rtit.esilv.bin1.esilv.basics.Session;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User RTIT
 *
 * Classe Database
**/
public class SessionDAO {
    /* Method(s) */
    /* Method: getAllSessions */
    /* Purpose: Get all sessions from database */
    /**
     * @return the ResultSet
     * @throws SQLException if there's an SQL error
    **/
    public static ArrayList<Session> getAllSessions() throws SQLException {
        // Variable(s)
        String request = "SELECT * FROM session;";
        ResultSet result = Database.query(request);
        ArrayList<Session> collection = new ArrayList<>();

        // Loop through the result
        while(result.next()) {
            // Attribute(s)
            int id = result.getInt("id");
            String specialite = result.getString("specialite");
            int jour = result.getInt("jour");
            int mois = result.getInt("mois");
            int id_conference = result.getInt("id_conference");

            // Create the session
            Session session = new Session(id, specialite, jour, mois, id_conference);

            // Add the session to the collection
            collection.add(session);
        }

        // Close & return
        result.close();
        return collection;
    }

    /* Method: getSessionByID */
    /* Purpose: Get a session by its ID */
    /**
     * @param id the session ID
     * @return the ResultSet
     * @throws SQLException if there's an SQL error
    **/
    public static Session getSessionByID(int id) throws SQLException {
        // Variable(s)
        String request = "SELECT * FROM session WHERE id = " + id + ";";
        ResultSet result = Database.query(request);
        Session session = null;

        // Loop through the result
        if(result.next()) {
            // Attribute(s)
            String specialite = result.getString("specialite");
            int jour = result.getInt("jour");
            int mois = result.getInt("mois");

            // Create the session
            session = new Session(specialite, jour, mois);
        }

        // Close & return
        result.close();
        return session;
    }

    /* Method: addSession */
    /* Purpose: Add a session */
    /**
     * @param session the session to add
     * @throws SQLException if there's an SQL error
    **/
    public static void addSession(Session session) throws SQLException {
        // Variable(s)
        String lastConfID = "SELECT MAX(id) FROM conference ORDER BY id DESC LIMIT 1;"; // Get the last conference ID
        ResultSet result = Database.query(lastConfID);
        int id;

        // Get the last conference ID
        if(result.next()) { id = result.getInt("MAX(id)"); }
        else {
            System.out.println("Erreur lors de la création d'une session.");
            System.out.println("Aucune conférence n'a été trouvée.");
            return;
        }

        // Create the request
        String request = "INSERT INTO session (specialite, jour, mois, id_conference) VALUES (\""
                + session.getSpecialite() + "\", "
                + session.getJour() + ", "
                + session.getMois() + ", "
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
    public static ArrayList<Session> getAllSessionsByID(int id) throws SQLException {
        // Variable(s)
        String request = "SELECT * FROM session WHERE id_conference = " + id + ";";
        ResultSet result = Database.query(request);
        ArrayList<Session> collection = new ArrayList<>();

        // Loop through the result
        while(result.next()) {
            // Attribute(s)
            int sessionID = result.getInt("id");
            String specialite = result.getString("specialite");
            int jour = result.getInt("jour");
            int mois = result.getInt("mois");
            int conferenceID = result.getInt("id_conference");

            // Create the session
            Session session = new Session(sessionID, specialite, jour, mois, conferenceID);

            // Add the session to the collection
            collection.add(session);
        }

        // Close & return
        result.close();
        return collection;
    }
}
