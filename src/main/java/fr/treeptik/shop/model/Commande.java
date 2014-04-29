package fr.treeptik.shop.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Date dateLivraison;
	private String adresse;
	
	public Commande() {}

	public Commande(Date dateLivraison, String adresse) {
		super();
		this.dateLivraison = dateLivraison;
		this.adresse = adresse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", dateLivraison=" + dateLivraison
				+ ", adresse=" + adresse + "]";
	}
	
	
	
}
