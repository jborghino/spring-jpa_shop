package fr.treeptik.shop.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Livre extends Article implements Serializable {

	private static final long serialVersionUID = 1L;

	private String auteur;
	private Integer nbPages;
	
	public Livre() {

	}

	public Livre(String auteur, Integer nbPages) {
		super();
		this.auteur = auteur;
		this.nbPages = nbPages;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Integer getNbPages() {
		return nbPages;
	}

	public void setNbPages(Integer nbPages) {
		this.nbPages = nbPages;
	}

	@Override
	public String toString() {
		return "Livre [id=" + super.getId() + ", prix=" + super.getPrix() + ", titre=" + super.getTitre() + ", auteur=" + auteur + ", nbPages=" + nbPages + "]";
		
	}
	
	
}
