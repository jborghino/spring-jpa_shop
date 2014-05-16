package fr.treeptik.shop.dao;

import java.util.List;

import fr.treeptik.shop.exception.DAOException;
import fr.treeptik.shop.model.Article;

public interface ArticleDAO extends GenericDAO<Article, Integer> {

	public List<Article> recherche(String pattern) throws DAOException;

	public List<Article> rechercheTrie(String pattern) throws DAOException;

}
