package fr.treeptik.shop.service;

import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.Client;

public interface ClientService {

	Client save(Client client) throws ServiceException;

	Client update(Client client) throws ServiceException;

	void remove(Client client) throws ServiceException;

	Client findById(Integer id) throws ServiceException;

	Client findAll() throws ServiceException;
	
}
