package fr.treeptik.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.shop.dao.DVDDAO;
import fr.treeptik.shop.exception.DAOException;
import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.DVD;
import fr.treeptik.shop.service.DVDService;

@Service
public class DVDServiceImpl implements DVDService{
	
	@Autowired
	private DVDDAO dvdDAO;

	@Override
	public List<DVD> recherche(String pattern) throws ServiceException {
		try {
			return dvdDAO.recherche(pattern);
		} catch (DAOException e) {
			throw new ServiceException("Erreur recherche dvd", e);
		}
	}

	@Override
	public List<DVD> rechercheTrie(String pattern) throws ServiceException {
		try {
			return dvdDAO.rechercheTrie(pattern);
		} catch (DAOException e) {
			throw new ServiceException("Erreur recherche triée dvd", e);
		}
	}

	

}
