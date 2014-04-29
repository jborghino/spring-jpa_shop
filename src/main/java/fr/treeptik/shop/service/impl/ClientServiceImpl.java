package fr.treeptik.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.shop.dao.ClientDAO;
import fr.treeptik.shop.exception.DAOException;
import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.Client;
import fr.treeptik.shop.service.ClientService;

//public class ClientServiceImpl extends GenericService<ClientDAO, Client, Integer>{
@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientDAO clientDAO;
	
//	@Override
//	protected ClientDAO getDao() {
//		return clientDAO;
//	}


	@Override
	@Transactional
	public Client save(Client client) throws ServiceException{
		try {
			return clientDAO.save(client);
		} catch (DAOException e) {
			throw new ServiceException("Erreur save client", e);
		}
	}
	
	@Override
	@Transactional
	public Client update(Client client) throws ServiceException{
		try {
			return clientDAO.update(client);
		} catch (DAOException e) {
			throw new ServiceException("Erreur update client", e);
		}
	}
	
	@Override
	@Transactional
	public void remove(Client client) throws ServiceException{
		try {
			client = this.findById(client.getId());
			clientDAO.remove(client);
		} catch (DAOException e) {
			throw new ServiceException("Erreur remove client", e);
		}
	}
	
	@Override
	public Client findById(Integer id) throws ServiceException{
		try {
			return clientDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException("Erreur findById client", e);
		}
	}
	
	@Override
	public List<Client> findAll() throws ServiceException{
		try {
			return (List<Client>) clientDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("Erreur findAll client", e);
		}
	}
	
	
	
}
