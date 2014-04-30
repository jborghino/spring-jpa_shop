package fr.treeptik.shop.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class DVD extends Article implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long duree;
	
	

	public DVD() {

	}

	public Long getDuree() {
		return duree;
	}

	public void setDuree(Long duree) {
		this.duree = duree;
	}

	@Override
	public String toString() {
		return "DVD [id=" + super.getId() + ", prix=" + super.getPrix() + ", titre=" + super.getTitre() + ", duree=" + duree + "]";
	}
	
	

}
