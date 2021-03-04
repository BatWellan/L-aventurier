package com.cirilGroup.aventurier;

import java.io.File;
import java.io.IOException;

import com.cirilGroup.aventurier.objects.Carte;
import com.cirilGroup.aventurier.utils.LecteurFichier;

public class AventurierApplication {

	public static void main(String[] args) {
		// On ouvre les 2 fichiers d'entrée
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File fichierCarte = new File(classLoader.getResource("carte.txt").getFile());
		File fichierInstructions = new File(classLoader.getResource("instructions.txt").getFile());
		Carte carte;
		try {
			// Initialisation de la carte avec le 1er fichier
			carte = LecteurFichier.lectureCarte(fichierCarte);
			// On initialise la position du personnage et on récupère les instructions
			String instructions = LecteurFichier.lectureInit(fichierInstructions, carte);
			// On éxécute les instructions une à une
			while(instructions.length() > 0) {
				carte.bouger(instructions.substring(0,1));
				System.out.println(carte.getPersonnage());
				instructions = instructions.substring(1);
			}
			System.out.println("Position finale");
			System.out.println(carte.getPersonnage());
		} catch (IOException e) {
			System.out.println("Fichier non trouvés ou illisibles");
		}
		
	}

}
