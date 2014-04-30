package fr.treeptik.shop.service;

import java.util.List;

import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.Livre;

public interface LivreService {

	public List<Livre> recherche(String pattern) throws ServiceException;

	public List<Livre> rechercheTrie(String pattern) throws ServiceException;

}
