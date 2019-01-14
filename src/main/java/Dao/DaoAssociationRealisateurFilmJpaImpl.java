package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Article;
import Model.AssocationRealisateurFilm;
import Model.AssociationRealisateurFilmPk;
import util.Context;

public class DaoAssociationRealisateurFilmJpaImpl implements DaoAssociationRealisateurFilm {

	@Override
	public List<AssocationRealisateurFilm> findAll() {
		EntityManager em = Context.getContext().createEntityManager();
		List<AssocationRealisateurFilm> asso =null;
		Query query = em.createQuery("from association_realisateur_film");
		asso = query.getResultList();
		return asso;
	}

	@Override
	public AssocationRealisateurFilm findByKey(AssociationRealisateurFilmPk key) {
		EntityManager em = Context.getContext().createEntityManager();
		AssocationRealisateurFilm asso=null;
		asso = em.find(AssocationRealisateurFilm.class, key);
		
		return asso;
	}

	@Override
	public void insert(AssocationRealisateurFilm obj) {
		EntityManager em = Context.getContext().createEntityManager();
		EntityTransaction tx = null;
		
		tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

	@Override
	public void update(AssocationRealisateurFilm obj) {
		EntityManager em = Context.getContext().createEntityManager();
		EntityTransaction tx = null;
		
		tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(obj);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

	@Override
	public void delete(AssocationRealisateurFilm obj) {
		EntityManager em = Context.getContext().createEntityManager();
		EntityTransaction tx = null;
		
		tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

	@Override
	public void deleteByKey(AssociationRealisateurFilmPk key) {
		EntityManager em = Context.getContext().createEntityManager();
		EntityTransaction tx = null;
		
		tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(AssocationRealisateurFilm.class, key));
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

}
