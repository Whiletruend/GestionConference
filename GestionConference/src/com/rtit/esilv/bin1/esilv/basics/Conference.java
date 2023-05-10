/* Import(s) & Package(s) */
package com.rtit.esilv.bin1.esilv.basics;
import java.util.ArrayList;

/**
 *
 * @author User RTIT
 *
 * Classe de gestion des Conférences
**/
public class Conference {
	/* Attribute(s) */
	private ArrayList<Session> sessions;
	private int id;
	private String nom;
	private String lieu;
	private int annee;

	/* Constructor(s) */
	public Conference() {
		this.sessions = new ArrayList<Session>();
	}

	/**
	 * @param id - format: id de la conférence
	 * @param nom - format: "Nom de la conférence"
	 * @param lieu - format: "Lieu de la conférence"
	 * @param annee - format: aaaa
	 **/
	public Conference(int id, String nom, String lieu, int annee) {
		this.id = id;
		this.nom = nom;
		this.lieu = lieu;
		this.annee = annee;
		this.sessions = new ArrayList<Session>();
	}

	/**
	 * @param nom - format: "Nom de la conférence"
	 * @param lieu - format: "Lieu de la conférence"
	 * @param annee - format: aaaa
	 **/
	public Conference(String nom, String lieu, int annee) {
		this.nom = nom;
		this.lieu = lieu;
		this.annee = annee;
		this.sessions = new ArrayList<Session>();
	}

	/**
	 * @param nom - format: "Nom de la conférence"
	 * @param lieu - format: "Lieu de la conférence"
	 * @param annee - format: aaaa
	 * @param sessions - format: ArrayList<Session> (liste d'objets Session)
	 **/
	public Conference(String nom, String lieu, int annee, ArrayList<Session> sessions) {
		this.nom = nom;
		this.lieu = lieu;
		this.annee = annee;
		this.sessions = sessions;
	}

	/* Getters */
	/** @return the id **/
	public int getId() { return id; }

	/** @return the nom **/
	public String getNom() { return nom; }

	/** @return the lieu **/
	public String getLieu() { return lieu; }

	/** @return the annee **/
	public int getAnnee() { return annee; }

	/** @return the sessions **/
	public ArrayList<Session> getSessions() { return sessions; }

	/* Setters */
	/** @param id the id to set **/
	public void setId(int id) { this.id = id; }

	/** @param nom the nom to set **/
	public void setNom(String nom) { this.nom = nom; }

	/** @param lieu the lieu to set **/
	public void setLieu(String lieu) { this.lieu = lieu; }

	/** @param annee the annee to set **/
	public void setAnnee(int annee) { this.annee = annee; }

	/** @param sessions the sessions to set **/
	public void setSessions(ArrayList<Session> sessions) { this.sessions = sessions; }


	/* Method(s) */
	/* Method: addSession */
	/* Purpose: Add a session to the current sessions list */
	/** @param session - format: Session (objet Session) **/
	public void addSession(Session session) {
		this.sessions.add(session);
	}

	/* Method: removeSession */
	/* Purpose: Remove a session from the current sessions list */
	/** @param session - format: Session (objet Session) **/
	public void removeSession(Session session) {
		this.sessions.remove(session);
	}

	/* Method: getUneSession */
	/* Purpose: Get a session from the current sessions list */
	/** @param i - format: int (index de la session) **/
	public Session getUneSession(int i) {
		return this.sessions.get(i);
	}

	/* Method: toString */
	/* Purpose: Return a string representation of the object */
	/** @return the string representation of the object **/
	@Override
	public String toString() {
		return "Conference{" + "nom=" + nom + ", lieu=" + lieu + ", annee=" + annee + ", sessions=" + sessions + '}';
	}
}