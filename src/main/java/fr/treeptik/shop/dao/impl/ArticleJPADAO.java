package fr.treeptik.shop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.shop.dao.ArticleDAO;
import fr.treeptik.shop.exception.DAOException;
import fr.treeptik.shop.model.Article;

@Repository
public class ArticleJPADAO extends GenericJPADAO<Article, Integer> implements
		ArticleDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public ArticleJPADAO() {
		super(Article.class);
	}

	@Override
	public List<Article> recherche(String pattern) throws DAOException {
		TypedQuery<Article> query3 = entityManager.createQuery(
				"select c from Article c where c.titre LIKE :pattern",
				Article.class);
		query3.setParameter("pattern", pattern + "%");
		List<Article> resultList = query3.getResultList();
		if (resultList != null) {
			return resultList;
		}
		return null;
	}

	@Override
	public List<Article> rechercheTrie(String pattern) throws DAOException {
		TypedQuery<Article> query3 = entityManager
				.createQuery(
						"select c from Article c where c.titre LIKE :pattern order by c.titre",
						Article.class);
		query3.setParameter("pattern", pattern + "%");

		List<Article> resultList = query3.getResultList();
		if (resultList != null) {
			return resultList;
		}
		return null;
	}

}
