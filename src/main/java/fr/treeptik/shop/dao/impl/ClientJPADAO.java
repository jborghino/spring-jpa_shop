package fr.treeptik.shop.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.treeptik.shop.dao.ClientDAO;
import fr.treeptik.shop.model.Client;

@Repository
public class ClientJPADAO extends GenericJPADAO<Client, Integer> implements ClientDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	public ClientJPADAO(){
		super(Client.class);
	}
	
}
