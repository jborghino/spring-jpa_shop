package fr.treeptik.shop.service;

import java.util.List;

import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.DVD;

public interface DVDService {

	public List<DVD> recherche(String pattern) throws ServiceException;

	public List<DVD> rechercheTrie(String pattern) throws ServiceException;

}
