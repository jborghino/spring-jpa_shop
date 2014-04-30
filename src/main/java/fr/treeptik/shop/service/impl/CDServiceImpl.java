package fr.treeptik.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.shop.dao.CDDAO;
import fr.treeptik.shop.exception.DAOException;
import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.CD;
import fr.treeptik.shop.service.CDService;

@Service
public class CDServiceImpl implements CDService{
	
	@Autowired
	private CDDAO cdDAO;

	@Override
	public List<CD> recherche(String pattern) throws ServiceException {
		try {
			return cdDAO.recherche(pattern);
		} catch (DAOException e) {
			throw new ServiceException("Erreur recherche cd", e);
		}
	}

	@Override
	public List<CD> rechercheTrie(String pattern) throws ServiceException {
		try {
			return cdDAO.rechercheTrie(pattern);
		} catch (DAOException e) {
			throw new ServiceException("Erreur recherche triée cd", e);
		}
	}

	

}
