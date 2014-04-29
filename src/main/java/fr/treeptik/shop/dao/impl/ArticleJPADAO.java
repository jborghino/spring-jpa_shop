package fr.treeptik.shop.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.treeptik.shop.dao.ArticleDAO;
import fr.treeptik.shop.model.Article;

@Repository
public class ArticleJPADAO extends GenericJPADAO<Article, Integer> implements ArticleDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	public ArticleJPADAO(){
		super(Article.class);
	}
	
}
