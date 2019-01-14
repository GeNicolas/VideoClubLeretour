package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Adherent;
import Model.Film;
import util.Context;

public class DaoFilmJpaImpl implements DaoFilm {

	@Override
	public List<Film> findAll() {
		EntityManager em = Context.getContext().createEntityManager();
		List<Film> films =null;
		Query query = em.createQuery("from Film");
		films = query.getResultList();
		return films;
	}

	@Override
	public Film findByKey(Integer key) {
		EntityManager em = Context.getContext().createEntityManager();
		Film f=null;
		f = em.find(Film.class, key);
		
		return f;
	}

	@Override
	public void insert(Film obj) {
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
	public void update(Film obj) {
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
	public void delete(Film obj) {
		EntityManager em = Context.getContext().createEntityManager();
		EntityTransaction tx = null;
		Film film = null;
		tx = em.getTransaction();
		try {
			tx.begin();
			film = em.find(Film.class, obj.getId_film());
			
			if (film.getArticles()!=null) {
				for (int i=0; i<film.getArticles().size(); i++ ) {
					film.getArticles().get(i).setFilm(null);
				}
					
			}
			
			em.remove(film);
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
		Film film = null;
		tx = em.getTransaction();
		try {
			tx.begin();
			film = em.find(Film.class, key);
			
			if (film.getArticles()!=null) {
				for (int i=0; i<film.getArticles().size(); i++ ) {
					film.getArticles().get(i).setFilm(null);
				}
					
			}
			
			em.remove(film);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

}
