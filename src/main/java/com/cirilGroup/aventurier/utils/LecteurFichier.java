package com.cirilGroup.aventurier.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.cirilGroup.aventurier.objects.Carte;
import com.cirilGroup.aventurier.objects.Personnage;

public class LecteurFichier {

	/**
	 * Initialisation de la carte selon le fichier d'entrée
	 * @param line
	 * @return
	 */
	public static Carte lectureCarte(File file) throws IOException {
		Carte carte = new Carte();
		InputStream inputStream = new FileInputStream(file);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
	        while ((line = br.readLine()) != null) {
	            carte.getEmplacements().add(lectureLigne(line));
	        }
		}
		return carte;
	}
	
	/**
	 * On récupère la position initiale de l'aventurier et ses instructions
	 * @param file
	 * @param carte
	 * @return
	 * @throws IOException
	 */
	public static String lectureInit(File file, Carte carte) throws IOException {
		InputStream inputStream = new FileInputStream(file);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line1= br.readLine();
			String[] coordonnees = line1.split(",");
			Personnage personnage = new Personnage(coordonnees[0], coordonnees[1]);
			carte.setPersonnage(personnage);
			String line2= br.readLine();
			System.out.println(line2);
			return line2;
		}
		
	}
	
	/**
	 * Initialisation de chaque ligne selon le fichier d'entrée
	 * @param line
	 * @return
	 */
	private static ArrayList<Boolean> lectureLigne(String line) {
		ArrayList<Boolean> ligneCarte = new ArrayList<>();
		while(!line.isEmpty()) {
			if(line.startsWith("#")) {
				ligneCarte.add(false);
			} else {
				ligneCarte.add(true);
			}
			line = line.substring(1);
		}
		return ligneCarte;
	}
}
