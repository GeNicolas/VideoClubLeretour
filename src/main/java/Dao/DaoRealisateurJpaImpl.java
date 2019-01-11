package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Film;
import Model.Realisateur;
import util.Context;

public class DaoRealisateurJpaImpl implements DaoRealisateur {

	@Override
	public List<Realisateur> findAll() {
		EntityManager em = Context.getContext().createEntityManager();
		List<Realisateur> realisateurs =null;
		Query query = em.createQuery("from Realisateur");
		realisateurs = query.getResultList();
		return realisateurs;
	}

	@Override
	public Realisateur findByKey(Integer key) {
		EntityManager em = Context.getContext().createEntityManager();
		Realisateur r=null;
		r = em.find(Realisateur.class, key);
		
		return r;
	}

	@Override
	public void insert(Realisateur obj) {
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
	public void update(Realisateur obj) {
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
	public void delete(Realisateur obj) {
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
	public void deleteByKey(Integer key) {
		EntityManager em = Context.getContext().createEntityManager();
		EntityTransaction tx = null;
		
		tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(Realisateur.class, key));
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

}
