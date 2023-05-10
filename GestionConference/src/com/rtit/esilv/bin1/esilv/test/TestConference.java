/* Import(s) & Package(s) */
package com.rtit.esilv.bin1.esilv.test;

import com.rtit.esilv.bin1.esilv.basics.*;
import com.rtit.esilv.bin1.esilv.dao.*;
import com.rtit.esilv.bin1.esilv.utils.Saisie;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author User RTIT
 *
 * Méthode de test des Conférences
 */
public class TestConference {
	public static void main(String[] args) throws SQLException {
		// Base
		System.out.println("Rendu Final 02 - Benjamin B. & Ewen B.");

		// Set-up menu
		while(true) {
			// Variable(s)
			Conference conference;

			// Menu to ask the user what he wants to do
			System.out.println();
			String action = Saisie.lireChaine(
					"Que souhaitez-vous faire ? : \n" +
							"1 - Créer une conférence \n" +
							"2 - Afficher les conférences \n" +
							"3 - Reporter une conférence \n" +
							"4 - Quitter \n" +
							"Votre choix : ");

			// Switch to do the action
			switch(action) {
				// Create a new conference
				case "1" -> {
					// Ask conference informations
					String is_online = Saisie.lireChoix("Conférence en ligne ? (O/N): ");
					String nom = Saisie.lireChaine("Nom de la conférence: ");
					String lieu = is_online.equalsIgnoreCase("N") ? Saisie.lireChaine("Lieu de la conférence: ") : "online";
					int annee = Saisie.lireEntier("Année de la conférence: ");
					String password = is_online.equalsIgnoreCase("N") ? "" : String.valueOf(Saisie.lireEntier("Mot de passe la conférence: "));
					int nbSessions = Saisie.lireEntier("Nombre de session(s): "); // Ask the number of sessions

					// Create the new conference
					if(is_online.equalsIgnoreCase("N")) {
						conference = new Conference(nom, lieu, annee);
					} else {
						conference = new ConferenceOnline(nom, annee, password);
					}

					// Add the conference to the database
					ConferenceDAO.addConference(conference); // Add the conference to the database

					// For each session asked
					for(int i = 0; i < nbSessions; i++) {
						// Attribute(s) for the session
						String thematique = Saisie.lireChaine("Thématique de la session: ");
						int mois = Saisie.lireMois("Mois de la session: ");
						int jour = Saisie.lireJour("Jour de la session: ", mois, annee);
						int nbPresentations = Saisie.lireEntier("Nombre de présentation(s): ");

						// Create the new session
						Session session = new Session(thematique, jour, mois);
						// Add the session to the conference & to the database
						conference.addSession(session);
						SessionDAO.addSession(session);

						// For each presentation asked
						for(int j = 0; j < nbPresentations; j++) {
							// Attribute(s) for the new presentation
							String titreArticle = Saisie.lireChaine("Titre de l'article: ");
							String auteurs = Saisie.lireChaine("Auteurs de l'article: ");

							// Create the new presentation
							Presentation presentation = new Presentation(auteurs, titreArticle, mois, jour, Integer.toString(j + 8));

							// Add the presentation to the session & to the database
							session.addPresentation(presentation);
							PresentationDAO.addPresentation(presentation); // Add the presentation to the database
						}
					}
				}

				// Display all the conferences
				case "2" -> {
					// Backslash
					System.out.println();

					// Get all the conferences
					try {
						// Variable(s)
						ArrayList<Conference> conferences = ConferenceDAO.getAllConferences();

						// For each conference
						for(Conference conf : conferences) {
							// Variable(s)
							int pres_amount = 0;

							// Show the conference
							if(conf.getLieu().equalsIgnoreCase("online")) {
								System.out.println("[" + conf.getId() + "] Conférence en ligne: " + conf.getNom() + " en " + conf.getAnnee() + " (" + ((ConferenceOnline) conf).getPassword() + ")");
							} else {
								System.out.println("[" + conf.getId() + "] Conférence: " + conf.getNom() + " en " + conf.getAnnee() + " à " + conf.getLieu());
							}

							// Count the number of presentations
							for(Session session : SessionDAO.getAllSessionsByID(conf.getId())) { pres_amount += PresentationDAO.getAllPresentationsByID(session.getId()).size(); }

							// Show informations of the conference (how much sessions + presentations)
							System.out.println("    -> Nombre de session(s): " + SessionDAO.getAllSessionsByID(conf.getId()).size());
							System.out.println("    -> Nombre de présentation(s): " + pres_amount + "\n");
						}

						// Show the number of conferences
						System.out.println("Nombre total de conférence(s): " + conferences.size());
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}

				// Report every conferences
				case "3" -> {
					// Variable(s)
					boolean validConference = false;

					// While (true)
					while (!validConference) {
						try {
							// Variable(s)
							int id = Saisie.lireEntier("ID de la conférence: "); // Ask for the conference ID
							conference = ConferenceDAO.getConferenceByID(id); // Get the conference by the ID

							// Check if the conference is valid
							if (conference != null) {
								// Variable(s)
								ArrayList<Session> sessions = SessionDAO.getAllSessionsByID(conference.getId()); // Get all the sessions
								ArrayList<Presentation> presentations = new ArrayList<>();

								// Set the presentations & sessions
								conference.setSessions(sessions);
								for(Session session: sessions) {
									presentations.addAll(PresentationDAO.getAllPresentationsByID(session.getId()));
									session.setPresentations(presentations);
								}

								// Write the conference in a file
								GestionFichier.writeFile(conference); // Write the conference in a file
								validConference = true; // The conference is valid, then turn it to true
							} else {
								System.out.println("La conférence n'existe pas. Veuillez réessayer.");
							}
						} catch (SQLException e) {
							throw new RuntimeException(e);
						}
					}
				}

				// Quit the program
				case "4" -> System.exit(0);

				// If the user didn't enter a valid choice
				default -> System.out.println("Veuillez entrer un choix valide.");
			}
		}
	}
}
