package fr.treeptik.shop.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class CD extends Article implements Serializable {

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
		return "CD [id=" + super.getId() + ", prix=" + super.getPrix()
				+ ", titre=" + super.getTitre() + ", auteur=" + auteur + "]";
	}

}
