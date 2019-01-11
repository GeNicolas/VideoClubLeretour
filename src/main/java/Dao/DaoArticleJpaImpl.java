package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Adherent;
import Model.Article;
import util.Context;

public class DaoArticleJpaImpl implements DaoArticle {

	@Override
	public List<Article> findAll() {
		EntityManager em = Context.getContext().createEntityManager();
		List<Article> articles =null;
		Query query = em.createQuery("from Article");
		articles = query.getResultList();
		return articles;
	}

	@Override
	public Article findByKey(Integer key) {
		EntityManager em = Context.getContext().createEntityManager();
		Article a=null;
		a = em.find(Article.class, key);
		
		return a;
	}

	@Override
	public void insert(Article obj) {
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
	public void update(Article obj) {
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
	public void delete(Article obj) {
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
			em.remove(em.find(Article.class, key));
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

}
