package fmi.friends.dao;

import javax.persistence.Query;


import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;


import fmi.friends.hibernateEntities.Shows;

public class ShowsDAO extends GenericDAO {
	public List<Shows> getShows(){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		EntityManager em=session.getEntityManagerFactory().createEntityManager();
		Query q=em.createQuery("SELECT s from Shows s order by s.creationDate ");
		List<Shows> toReturn= q.getResultList();
		tx.commit();
		return toReturn;
	}
}