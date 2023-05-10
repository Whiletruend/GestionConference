/* Import(s) & Package(s) */
package com.rtit.esilv.bin1.esilv.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
  *
  * @author User RTIT
  *
  * Méthode de Saisie
 */
 public class Saisie {
	/* Method(s) */
	/* Method: lireChaine */
	/* Purpose: Read a string from the keyboard */
	/**
	 * @param message - format: "Message to display"
	 * @return the string
	 */
	public static String lireChaine(String message) {
		// Variable(s)
		String ligne;

		// Try catch
		do {
			try {
				// Variable(s)
				InputStreamReader isr = new InputStreamReader(System.in); // Convert the binary to a string (unicode)
				BufferedReader br = new BufferedReader(isr); // Construct a BufferedReader from InputStreamReader

				// Show the message
				System.out.print(message);
				ligne = br.readLine().trim(); // Read a line of text

				if(ligne.isEmpty()) {
					System.out.println("Veuillez entrer une chaîne valide");
				} else {
					break;
				}
			} catch (IOException e) { // Catch the exception
				throw new RuntimeException(e); // Rethrow the exception
			}
		} while(true);

		// Return
		return ligne;
	}

	/* Method: lireChoix */
	/* Purpose: Read a choice from the keyboard */
	/**
	 * @param message - format: "Message to display"
	 * @return the choice
	**/
	public static String lireChoix(String message) {
		while(true) {
			// Variable(s)
			String input = lireChaine(message);

			// Check if the input is valid
			if(input.equalsIgnoreCase("O") || input.equalsIgnoreCase("N")) {
				return input.toUpperCase();
			} else {
				System.out.println("Veuillez entrer une réponse valide (O/N)");
			}
		}
	}

	/* Method: lireJour */
	/* Purpose: Read a day from the keyboard */
	/**
	 * @param message - format: "Message to display"
	 * @param month - format: 4
	 * @param year - format: 2023
	 * @return the day
	**/
	public static int lireJour(String message, int month, int year) {
		while (true) {
			try {
				// Variable(s)
				int day = Integer.parseInt(lireChaine(message));

				// Check if the day & month are valid
				if (day < 1 || day > 31) { throw new IllegalArgumentException("Veuillez entrer un jour valide."); } // Check if the day is between 1 & 31
				if (month == 2) {
					if (day > 28 && (day != 29 || year % 4 != 0)) { throw new IllegalArgumentException("Veuillez entrer un jour valide."); } // Check if the year is a leap year (february)
				} else if (month == 4 || month == 6 || month == 9 || month == 11) {
					if (day > 30) { throw new IllegalArgumentException("Veuillez entrer un jour valide."); } // Check if the month has 30 days
				}

				// Return
				return day;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}


	/* Method: lireMois */
	/* Purpose: Read a month from the keyboard */
	/**
	 * @param message - format: "Message to display"
	 * @return the month
	**/
	public static int lireMois(String message) {
		while (true) {
			try {
				int month = Integer.parseInt(lireChaine(message)); // Read the month
				if (month < 1 || month > 12) { throw new IllegalArgumentException("Veuillez entrer un mois valide."); } // Check if the month is valid

				return month;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}


	/* Method: lireEntier */
	/* Purpose: Read an integer from the keyboard */
	/**
	 * @param message - format: "Message to display"
	 * @return the integer
	 */
	public static int lireEntier(String message) {
		while(true) {
			try {
				return Integer.parseInt(lireChaine(message));
			} catch (Exception e) {
				System.out.println("Veuillez entrer un nombre valide.");
			}
		}
	}

	/* Method: lireDouble */
	/* Purpose: Read a double from the keyboard */
}