package fr.treeptik.shop.service;

import java.util.List;

import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.CD;

public interface CDService {

	public List<CD> recherche(String pattern) throws ServiceException;

	public List<CD> rechercheTrie(String pattern) throws ServiceException;

}
