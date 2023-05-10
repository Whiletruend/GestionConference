/* Import(s) & Package(s) */
package com.rtit.esilv.bin1.esilv.basics;
import java.util.ArrayList;

/**
 *
 * @author User RTIT
 *
 * Classe de gestion des Sessions
**/
public class Session {
	/* Attribute(s) */
	private int id;
	private String specialite;
	private int jour;
	private int mois;
	private ArrayList<Presentation> presentations;

	/* Constructor(s) */
	/**
	 * @param id - format: id de la session
	 * @param specialite - format: "Spécialité"
	 * @param jour - format: jj (jj: 01 à 31)
	 * @param mois - format: mm (mm: 01 à 12)
	 **/
	public Session(int id, String specialite, int jour, int mois, int id_conference) {
		this.id = id;
		this.specialite = specialite;
		this.jour = jour;
		this.mois = mois;
		this.presentations = new ArrayList<Presentation>();
	}

	/**
	 * @param specialite - format: "Spécialité"
	 * @param jour - format: jj (jj: 01 à 31)
	 * @param mois - format: mm (mm: 01 à 12)
	 **/
	public Session(String specialite, int jour, int mois) {
		this.specialite = specialite;
		this.jour = jour;
		this.mois = mois;
		this.presentations = new ArrayList<Presentation>();
	}

	/**
	 * @param specialite - format: "Spécialité"
	 * @param jour - format: jj (jj: 01 à 31)
	 * @param mois - format: mm (mm: 01 à 12)
	 * @param presentations - format: ArrayList<Presentation> (liste d'objets Presentation)
	 **/
	public Session(String specialite, int jour, int mois, ArrayList<Presentation> presentations) {
		this.specialite = specialite;
		this.jour = jour;
		this.mois = mois;
		this.presentations = presentations;
	}

	/* Getters */
	/** @return the id **/
	public int getId() { return id; }

	/** @return the specialite **/
	public String getSpecialite() { return specialite; }

	/** @return the jour **/
	public int getJour() { return jour; }

	/** @return the mois **/
	public int getMois() { return mois; }

	/** @return the presentations **/
	public ArrayList<Presentation> getPresentations() { return presentations; }

	/* Setters */
	/** @param id the id to set **/
	public void setId(int id) { this.id = id; }

	/** @param specialite the specialite to set **/
	public void setSpecialite(String specialite) { this.specialite = specialite; }

	/** @param jour the jour to set **/
	public void setJour(int jour) { this.jour = jour; }

	/** @param mois the mois to set **/
	public void setMois(int mois) { this.mois = mois; }

	/** @param presentations the presentations to set **/
	public void setPresentations(ArrayList<Presentation> presentations) { this.presentations = presentations; }

	/* Method(s) */
	/* Method: addPresentation */
	/* Purpose: Add a presentation to the session */
	/** @param presentation - format: Presentation (objet Presentation) **/
	public void addPresentation(Presentation presentation) {
		this.presentations.add(presentation);
	}

	/* Method: removePresentation */
	/* Purpose: Remove a presentation from the session */
	/** @param presentation - format: Presentation (objet Presentation) **/
	public void removePresentation(Presentation presentation) {
		this.presentations.remove(presentation);
	}

	/* Method: toString */
	/* Purpose: Return a string representation of the object */
	/** @return the string representation of the object **/
	@Override
	public String toString() {
		return "Session{" + "specialite=" + specialite + ", jour=" + jour + ", mois=" + mois + ", presentations=" + presentations + '}';
	}
}