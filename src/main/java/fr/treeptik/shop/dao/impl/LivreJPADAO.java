package fr.treeptik.shop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.treeptik.shop.dao.LivreDAO;
import fr.treeptik.shop.model.Livre;

@Repository
public class LivreJPADAO extends GenericJPADAO<Livre, Integer> implements LivreDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public LivreJPADAO() {
		super(Livre.class);
	}

	@Override
	public List<Livre> recherche(String pattern) {
		TypedQuery<Livre> query3 = entityManager.createQuery(
				"select c from Livre c where c.titre LIKE :pattern", Livre.class);
		query3.setParameter("pattern", pattern + "%");
		List<Livre> resultList = query3.getResultList();
		if (resultList != null) {
			return resultList;
		}
		return null;
	}

	@Override
	public List<Livre> rechercheTrie(String pattern) {
		TypedQuery<Livre> query3 = entityManager
				.createQuery(
						"select c from Livre c where c.titre LIKE :pattern order by c.titre",
						Livre.class);
		query3.setParameter("pattern", pattern + "%");

		List<Livre> resultList = query3.getResultList();
		if (resultList != null) {
			return resultList;
		}
		return null;
	}

}
