package fr.treeptik.shop.dao;

import java.util.List;

import fr.treeptik.shop.exception.DAOException;
import fr.treeptik.shop.model.DVD;

public interface DVDDAO extends GenericDAO<DVD, Integer>{

	public List<DVD> recherche(String pattern) throws DAOException;
	public List<DVD> rechercheTrie(String pattern) throws DAOException;

}
