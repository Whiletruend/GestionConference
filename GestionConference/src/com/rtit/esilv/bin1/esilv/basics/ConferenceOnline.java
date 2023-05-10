/* Import(s) & Package(s) */
package com.rtit.esilv.bin1.esilv.basics;

/**
 *
 * @author User RTIT
 *
 * Classe de gestion des Conférences en ligne
**/
public class ConferenceOnline extends Conference {
	/* Attribute(s) */
	private String url;
	private String password;

	/* Constructor(s) */
	/**
	 * @param id - format: id de la conférence
	 * @param nom - format: "Nom de la conférence"
	 * @param annee - format: aaaa
	 * @param password - format: "Mot de passe de la conférence"
	 **/
	public ConferenceOnline(int id, String nom, int annee, String password) {
		// Call the parent constructor
		super(id, nom, "online", annee);

		// Format password & url
		String formatted_password = password.replaceAll("\\D", ""); // Remove all non-digits characters
		String formatted_url = "https://" + nom.toLowerCase() + Integer.toString(annee).toLowerCase() + "-online.zoom.us/" + formatted_password;
		formatted_url = formatted_url.replaceAll("[\\\\;#\\s\\n']", ""); // Remove all special characters (\, ;, #, space, new line, ')

		// Set the attributes
		this.url = formatted_url;
		this.password = formatted_password;
	}

	/**
	 * @param nom - format: "Nom de la conférence"
	 * @param annee - format: aaaa
	 * @param password - format: "Mot de passe de la conférence"
	 **/
	public ConferenceOnline(String nom, int annee, String password) {
		// Call the parent constructor
		super(nom, "online", annee);

		// Format password & url
		String formatted_password = password.replaceAll("\\D", ""); // Remove all non-digits characters
		String formatted_url = "https://" + nom.toLowerCase() + Integer.toString(annee).toLowerCase() + "-online.zoom.us/" + formatted_password;
		formatted_url = formatted_url.replaceAll("[\\\\;#\\s\\n']", ""); // Remove all special characters (\, ;, #, space, new line, ')

		// Set the attributes
		this.url = formatted_url;
		this.password = formatted_password;
	}

	/* Getters */
	/** @return the url **/
	public String getUrl() { return url; }

	/** @return the password **/
	public String getPassword() { return password; }

	/* Setters */
	/** @param url the url to set **/
	public void setUrl(String url) { this.url = url; }

	/** @param password the password to set **/
	public void setPassword(String password) { this.password = password; }

	/* Method(s) */
	/* Method: toString */
	/* Purpose: Show the ConferenceOnline object */
	/** @return the ConferenceOnline object **/
	@Override
	public String toString() {
		return "ConferenceOnline [url=" + url + ", password=" + password + ", getNom()=" + getNom() + ", getLieu()="
				+ getLieu() + ", getAnnee()=" + getAnnee() + "]";
	}
}