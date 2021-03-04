package com.cirilGroup.aventurier.objects;
import java.util.ArrayList;
import java.util.List;

public class Carte {
	
	private List<ArrayList<Boolean>> emplacements;
	private Personnage personnage;
	
	public Carte() {
		emplacements = new ArrayList<ArrayList<Boolean>>();
	}
	public List<ArrayList<Boolean>> getEmplacements() {
		return emplacements;
	}
	public void setEmplacements(List<ArrayList<Boolean>> emplacements) {
		this.emplacements = emplacements;
	}
	public Personnage getPersonnage() {
		return personnage;
	}
	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}
	
	/**
	 *  Méthode pour simuler un déplacement du personnage
	 * @param direction
	 */
	public void bouger(String direction) {
		int newX = personnage.getX();
		int newY = personnage.getY();
		// Pour chaque mouvement, on vérifie si le déplacement nous fait aller dans un bois ou sortir de la carte, 
		// on bouge si non
		switch(direction) {
			// Mouvement vers l'ouest
			case "O": 
				if(newX == 0) {
					break;
				}
				if(emplacements.get(newY).get(newX - 1)) {
					newX--;
				}
				break;
			// Mouvement vers l'est
			case "E": 
				if(newX == emplacements.get(newX).size()) {
					break;
				}
				if(emplacements.get(newY).get(newX +1)) {
					newX++;
				}
				break;
			// Mouvement vers le sud
			case "S": 
				if(newY == emplacements.size()) {
					break;
				}
				if(emplacements.get(newY + 1).get(newX)) {
					newY++;
				}
				break;
			// Mouvement vers le nord
			case "N": 
				if(newY == 0) {
					break;
				}
				if(emplacements.get(newY - 1).get(newX)) {
					newY--;
				}
				break;
			default: 
				break;
		}
		// On sauvegarde la position finale
		personnage.setX(newX);
		personnage.setY(newY);
		
	}

}
