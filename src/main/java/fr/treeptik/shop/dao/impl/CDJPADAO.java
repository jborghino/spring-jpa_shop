package fr.treeptik.shop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.shop.dao.CDDAO;
import fr.treeptik.shop.model.CD;

@Repository
public class CDJPADAO extends GenericJPADAO<CD, Integer> implements CDDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public CDJPADAO() {
		super(CD.class);
	}

	@Override
	public List<CD> recherche(String pattern) {
		TypedQuery<CD> query3 = entityManager.createQuery(
				"select c from CD c where c.titre LIKE :pattern", CD.class);
		query3.setParameter("pattern", pattern + "%");
		List<CD> resultList = query3.getResultList();
		if (resultList != null) {
			return resultList;
		}
		return null;
	}

	@Override
	public List<CD> rechercheTrie(String pattern) {
		TypedQuery<CD> query3 = entityManager
				.createQuery(
						"select c from CD c where c.titre LIKE :pattern order by c.titre",
						CD.class);
		query3.setParameter("pattern", pattern + "%");

		List<CD> resultList = query3.getResultList();
		if (resultList != null) {
			return resultList;
		}
		return null;
	}

}
