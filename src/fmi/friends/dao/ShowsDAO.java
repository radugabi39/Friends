package fmi.friends.dao;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fmi.friends.hibernateEntities.Shows;

public class ShowsDAO extends GenericDAO {
	public List<Shows> getAllShows() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=null;
		if(session.getTransaction()!=null && session.getTransaction().isActive()){
			tx=	session.getTransaction();
		}else{
			tx=session.beginTransaction();
		}
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT s from Shows s order by s.creationDate ");
		List<Shows> toReturn = q.getResultList();
		tx.commit();
		return toReturn;
	}

	public Shows getShow(int id){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=null;
		if(session.getTransaction()!=null && session.getTransaction().isActive()){
			tx=	session.getTransaction();
		}else{
			tx=session.beginTransaction();
		}
		EntityManager em=session.getEntityManagerFactory().createEntityManager();
		Query q=em.createQuery("SELECT s from Shows s where s.id=:id ").setParameter("id", id);
		List<Shows> toReturn= q.getResultList();
		tx.commit();
		
		if(toReturn!=null && toReturn.size()>0){
			return toReturn.get(0);
		}else{
			return null;
		}
	}
	
	public List<Shows> getShowsOrderByCreationDate(){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=null;
		if(session.getTransaction()!=null && session.getTransaction().isActive()){
			tx=	session.getTransaction();
		}else{
			tx=session.beginTransaction();
		}
		EntityManager em=session.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT s from Shows s order by s.creationDate desc");
		List<Shows> toReturn = q.getResultList();
		tx.commit();
		return toReturn;
	}
	
	public List<Shows> getShowsOrderByReviews(){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=null;
		if(session.getTransaction()!=null && session.getTransaction().isActive()){
			tx=	session.getTransaction();
		}else{
			tx=session.beginTransaction();
		}
		EntityManager em=session.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT s from Shows s"
				+ " left join s.reviews rev group by s.id order by count(rev) desc");
		List<Shows> toReturn = q.getResultList();
		tx.commit();
		return toReturn;
	}
//	
}
