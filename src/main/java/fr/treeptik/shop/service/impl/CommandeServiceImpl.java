package fr.treeptik.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.shop.dao.CommandeDAO;
import fr.treeptik.shop.exception.DAOException;
import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.Commande;
import fr.treeptik.shop.service.CommandeService;

//public class CommandeServiceImpl extends GenericService<CommandeDAO, Commande, Integer>{
@Service
public class CommandeServiceImpl implements CommandeService{
	
	@Autowired
	private CommandeDAO commandeDAO;
	
//	@Override
//	protected CommandeDAO getDao() {
//		return commandeDAO;
//	}


	@Override
	@Transactional
	public Commande save(Commande commande) throws ServiceException{
		try {
			return commandeDAO.save(commande);
		} catch (DAOException e) {
			throw new ServiceException("Erreur save commande", e);
		}
	}
	
	@Override
	@Transactional
	public Commande update(Commande commande) throws ServiceException{
		try {
			return commandeDAO.update(commande);
		} catch (DAOException e) {
			throw new ServiceException("Erreur update commande", e);
		}
	}
	
	@Override
	@Transactional
	public void remove(Commande commande) throws ServiceException{
		try {
			commande = this.findById(commande.getId());
			commandeDAO.remove(commande);
		} catch (DAOException e) {
			throw new ServiceException("Erreur remove commande", e);
		}
	}
	
	@Override
	public Commande findById(Integer id) throws ServiceException{
		try {
			return commandeDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException("Erreur findById commande", e);
		}
	}
	
	@Override
	public Commande findAll() throws ServiceException{
		try {
			return (Commande) commandeDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("Erreur findAll commande", e);
		}
	}
	
	
	
}
