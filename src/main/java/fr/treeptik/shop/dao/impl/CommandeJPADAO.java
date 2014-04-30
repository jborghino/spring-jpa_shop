package fr.treeptik.shop.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.treeptik.shop.dao.CommandeDAO;
import fr.treeptik.shop.model.Commande;

@Repository
public class CommandeJPADAO extends GenericJPADAO<Commande, Integer> implements CommandeDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	public CommandeJPADAO(){
		super(Commande.class);
	}
	
}
