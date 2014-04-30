package fr.treeptik.shop.service;

import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.Commande;

public interface CommandeService {

	Commande save(Commande commande) throws ServiceException;

	Commande update(Commande commande) throws ServiceException;

	void remove(Commande commande) throws ServiceException;

	Commande findById(Integer id) throws ServiceException;

	Commande findAll() throws ServiceException;
	
}
