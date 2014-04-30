package fr.treeptik.shop.dao;

import java.util.List;

import fr.treeptik.shop.exception.DAOException;
import fr.treeptik.shop.model.Livre;

public interface LivreDAO extends GenericDAO<Livre, Integer> {

	public List<Livre> recherche(String pattern) throws DAOException;

	public List<Livre> rechercheTrie(String pattern) throws DAOException;

}
