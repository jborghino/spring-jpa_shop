package fr.treeptik.shop.model;

import java.io.Serializable;

public class DVD implements Serializable {

	private static final long serialVersionUID = 1L;

	private String titre;
	
	public DVD() {

	}

	public DVD(String titre) {
		super();
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "DVD [titre=" + titre + "]";
	}
	
	

}
