package fr.treeptik.shop.dao;

import java.util.List;

import fr.treeptik.shop.exception.DAOException;
import fr.treeptik.shop.model.CD;


public interface CDDAO extends GenericDAO<CD, Integer>{

	public List<CD> recherche(String pattern) throws DAOException;
	
	public List<CD> rechercheTrie(String pattern) throws DAOException;

}
