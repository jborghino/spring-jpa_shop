package fr.treeptik.shop.service;

import java.util.List;

import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.Article;

public interface ArticleService {

	Article save(Article article) throws ServiceException;

	Article update(Article article) throws ServiceException;

	void remove(Article article) throws ServiceException;

	Article findById(Integer id) throws ServiceException;

	List<Article> findAll() throws ServiceException;
	
}
