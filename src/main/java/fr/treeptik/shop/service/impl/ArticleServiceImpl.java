package fr.treeptik.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.shop.dao.ArticleDAO;
import fr.treeptik.shop.exception.DAOException;
import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.Article;
import fr.treeptik.shop.service.ArticleService;

//public class ArticleServiceImpl extends GenericService<ArticleDAO, Article, Integer>{
@Service
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	private ArticleDAO articleDAO;
	
//	@Override
//	protected ArticleDAO getDao() {
//		return articleDAO;
//	}


	@Override
	@Transactional
	public Article save(Article article) throws ServiceException{
		try {
			return articleDAO.save(article);
		} catch (DAOException e) {
			throw new ServiceException("Erreur save article", e);
		}
	}
	
	@Override
	@Transactional
	public Article update(Article article) throws ServiceException{
		try {
			return articleDAO.update(article);
		} catch (DAOException e) {
			throw new ServiceException("Erreur update article", e);
		}
	}
	
	@Override
	@Transactional
	public void remove(Article article) throws ServiceException{
		try {
			article = this.findById(article.getId());
			articleDAO.remove(article);
		} catch (DAOException e) {
			throw new ServiceException("Erreur remove article", e);
		}
	}
	
	@Override
	public Article findById(Integer id) throws ServiceException{
		try {
			return articleDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException("Erreur findById article", e);
		}
	}
	
	@Override
	public List<Article> findAll() throws ServiceException{
		try {
			return articleDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("Erreur findAll article", e);
		}
	}

	@Override
	public List<Article> recherche(String pattern) throws ServiceException {
		try {
			return articleDAO.recherche(pattern);
		} catch (DAOException e) {
			throw new ServiceException("Erreur recherche article", e);
		}
	}

	@Override
	public List<Article> rechercheTrie(String pattern) throws ServiceException {
		try {
			return articleDAO.rechercheTrie(pattern);
		} catch (DAOException e) {
			throw new ServiceException("Erreur recherche triée article", e);
		}
	}
	
	
	
}
