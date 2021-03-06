package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Adherent;

import util.Context;

public class DaoAdherentJpaImpl implements DaoAdherent {

	@Override
	public List<Adherent> findAll() {
		EntityManager em = Context.getContext().createEntityManager();
		List<Adherent> adherents =null;
		Query query = em.createQuery("from Adherent");
		adherents = query.getResultList();
		return adherents;
	}

	@Override
	public Adherent findByKey(Integer key) {
		EntityManager em = Context.getContext().createEntityManager();
		Adherent adh=null;
		adh = em.find(Adherent.class, key);
		
		return adh;
	}

	@Override
	public void insert(Adherent obj) {
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
	public void update(Adherent obj) {
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
	public void delete(Adherent obj) {
		EntityManager em = Context.getContext().createEntityManager();
		EntityTransaction tx = null;
		Adherent adherent = null;
		tx = em.getTransaction();
		try {
			tx.begin();
			adherent = em.find(Adherent.class, obj.getNoAdherent());
			
			if (adherent.getArticles()!=null) {
				for (int i=0; i<adherent.getArticles().size(); i++ ) {
					adherent.getArticles().get(i).setEmprunteur(null);
				}
					
			}
			
			em.remove(adherent);
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
		Adherent adherent = null;
		tx = em.getTransaction();
		try {
			tx.begin();
			adherent = em.find(Adherent.class, key);
			
			if (adherent.getArticles()!=null) {
				for (int i=0; i<adherent.getArticles().size(); i++ ) {
					adherent.getArticles().get(i).setEmprunteur(null);
				}
					
			}
			
			em.remove(adherent);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}
	
	

}
