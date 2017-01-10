package fmi.friends.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class UserDAO  extends GenericDAO {
	public Integer getPointsByUser(int userId) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT u.points from User u where u.id=:userId").setParameter("userId", userId);
		List<Integer> toReturn = q.getResultList();
		tx.commit();
		if(toReturn!=null && toReturn.size()>0){
			return toReturn.get(0);
		}else{
			return null;
		}

	}
}
