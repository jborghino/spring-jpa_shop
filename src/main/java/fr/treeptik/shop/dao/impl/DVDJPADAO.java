package fr.treeptik.shop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.shop.dao.DVDDAO;
import fr.treeptik.shop.model.DVD;

@Repository
public class DVDJPADAO extends GenericJPADAO<DVD, Integer> implements DVDDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public DVDJPADAO() {
		super(DVD.class);
	}

	@Override
	public List<DVD> recherche(String pattern) {
		TypedQuery<DVD> query3 = entityManager.createQuery(
				"select c from DVD c where c.titre LIKE :pattern", DVD.class);
		query3.setParameter("pattern", pattern + "%");
		List<DVD> resultList = query3.getResultList();
		if (resultList != null) {
			return resultList;
		}
		return null;
	}

	@Override
	public List<DVD> rechercheTrie(String pattern) {
		TypedQuery<DVD> query3 = entityManager
				.createQuery(
						"select c from DVD c where c.titre LIKE :pattern order by c.titre",
						DVD.class);
		query3.setParameter("pattern", pattern + "%");

		List<DVD> resultList = query3.getResultList();
		if (resultList != null) {
			return resultList;
		}
		return null;
	}

}
