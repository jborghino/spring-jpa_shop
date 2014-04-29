package fr.treeptik.shop.model;

import java.io.Serializable;

public class CD implements Serializable {

	private static final long serialVersionUID = 1L;

	private String auteur;
	
	public CD() {

	}

	public CD(String auteur) {
		super();
		this.auteur = auteur;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "CD [auteur=" + auteur + "]";
	}
	
	
	
}
