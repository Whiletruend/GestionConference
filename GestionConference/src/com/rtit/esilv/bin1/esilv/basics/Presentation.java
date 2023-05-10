/* Import(s) & Package(s) */
package com.rtit.esilv.bin1.esilv.basics;

/**
 *
 * @author User RTIT
 *
 * Classe de gestion des Présentations
**/
public class Presentation {
	/* Attribute(s) */
	private int id;
	private String auteurs;
	private String titreArticle;
	private int mois;
	private int jour;
	private String heure;
	private int id_session;

	/* Constructor(s) */
	/**
	 * @param id - format: id de la présentation
	 * @param auteurs - format: "Nom1 Prénom1, Nom2 Prénom2, ..."
	 * @param titreArticle - format: "Titre de l'article"
	 * @param mois - format: mm (mm: 01 à 12)
	 * @param jour - format: jj (jj: 01 à 31)
	 * @param heure - format: hh:mm:ss (hh: 00 à 23) (mm: 00 à 59) (ss: 00 à 59)
	**/
	public Presentation(int id, String auteurs, String titreArticle, int mois, int jour, String heure) {
		this.id = id;
		this.auteurs = auteurs;
		this.titreArticle = titreArticle;
		this.mois = mois;
		this.jour = jour;
		this.heure = heure;
	}

	/**
	 * @param auteurs - format: "Nom1 Prénom1, Nom2 Prénom2, ..."
	 * @param titreArticle - format: "Titre de l'article"
	 * @param mois - format: mm (mm: 01 à 12)
	 * @param jour - format: jj (jj: 01 à 31)
	 * @param heure - format: hh:mm:ss (hh: 00 à 23) (mm: 00 à 59) (ss: 00 à 59)
	**/
	public Presentation(String auteurs, String titreArticle, int mois, int jour, String heure) {
		this.auteurs = auteurs;
		this.titreArticle = titreArticle;
		this.mois = mois;
		this.jour = jour;
		this.heure = heure;
	}

	/**
	 * @param auteurs - format: "Nom1 Prénom1, Nom2 Prénom2, ..."
	 * @param titreArticle - format: "Titre de l'article"
	 * @param mois - format: mm (mm: 01 à 12)
	 * @param jour - format: jj (jj: 01 à 31)
	 * @param heure - format: hh:mm:ss (hh: 00 à 23) (mm: 00 à 59) (ss: 00 à 59)
	**/
	public Presentation(String auteurs, String titreArticle, int mois, int jour, String heure, int id_session) {
		this.auteurs = auteurs;
		this.titreArticle = titreArticle;
		this.mois = mois;
		this.jour = jour;
		this.heure = heure;
		this.id_session = id_session;
	}

	/* Getters */
	/** @return the id **/
	public int getId() { return id; }

	/** @return the auteurs **/
	public String getAuteurs() { return auteurs; }

	/** @return the titreArticle **/
	public String getTitreArticle() { return titreArticle; }

	/** @return the mois **/
	public int getMois() { return mois; }

	/** @return the jour **/
	public int getJour() { return jour; }

	/** @return the heure **/
	public String getHeure() { return heure; }

	/** @return the id_session **/
	public int getIdSession() { return id_session; }

	/* Setters */
	/** @param id the id to set **/
	public void setId(int id) { this.id = id; }

	/** @param auteurs the auteurs to set **/
	public void setAuteurs(String auteurs) { this.auteurs = auteurs; }

	/** @param titreArticle the titreArticle to set **/
	public void setTitreArticle(String titreArticle) { this.titreArticle = titreArticle; }

	/** @param mois the mois to set **/
	public void setMois(int mois) { this.mois = mois; }

	/** @param jour the jour to set **/
	public void setJour(int jour) { this.jour = jour; }

	/** @param heure the heure to set **/
	public void setHeure(String heure) { this.heure = heure; }

	/** @param id_session the id_session to set **/
	public void setIdSession(int id_session) { this.id_session = id_session; }

	/* Method(s) */
	/* Method: toString */
	/* Purpose: Show the current presentation with its title, authors and time */
	/** @return the string representation of the object **/
	@Override
	public String toString() {
		return "Présentation de l'article \"" + titreArticle + "\" par " + auteurs + " à " + heure + " heures";
	}
}