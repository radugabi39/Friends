package fmi.friends.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fmi.friends.hibernateEntities.Token;
import fmi.friends.hibernateEntities.User;
import fmi.friends.models.ItemUPModel;
import fmi.friends.models.ReviewModelUPModel;
import fmi.friends.models.UserProfileModel;



public class UserDAO  extends GenericDAO {
	static final long ONE_MINUTE_IN_MILLIS=60000;
	public Integer getPointsByUser(int userId) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=null;
		if(session.getTransaction()!=null && session.getTransaction().isActive()){
			tx=	session.getTransaction();
		}else{
			tx=session.beginTransaction();
		}
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
	public User checkUser(String username,String password) throws Exception{ 
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=null;
		if(session.getTransaction()!=null && session.getTransaction().isActive()){
			tx=	session.getTransaction();
		}else{
			tx=session.beginTransaction();
		}
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
	Query query = em.createQuery(
			"select u from User u where userName = :username and password = :password"
		);
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		User user = (User) query.getSingleResult();
		if (user == null) {
			 throw new Exception("User does not exists!");
		}else{
			return user;
		}
	}
	
	public void saveToken(Integer userID,String token) throws Exception{ 
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=null;
		if(session.getTransaction()!=null && session.getTransaction().isActive()){
			tx=	session.getTransaction();
		}else{
			tx=session.beginTransaction();
		}
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		Calendar date = Calendar.getInstance();
		long t= date.getTimeInMillis();
		Date afterAdding=new Date(t + (30 * ONE_MINUTE_IN_MILLIS));
		Token newToken = new Token();
		newToken.setUserID(userID);
		newToken.setToken(token);
		newToken.setExpiration(afterAdding);
		session.persist(newToken);
		tx.commit();
		session.close();
	}
	
	public boolean checkToken(String token){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		Query que= em.createQuery("SELECT t from Token t where t.token=:token and t.expiration>:expDate");
				que.setParameter("token", token);
				que.setParameter("expDate", new Date());
	
		Token t= (Token) que.getSingleResult();
		tx.commit();
		if(t==null){
			return false;
		}else{
			return true;
		}
	}
	public Integer getUserByToken(String token){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		Query que= em.createQuery("SELECT t.userID from Token t where t.token=:token");
				que.setParameter("token", token);

	
		Integer t= (Integer) que.getSingleResult();
		tx.commit();
		return t;
	}
	public UserProfileModel getUserProfile(int userId){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT new fmi.friends.models.UserProfileModel(concat(u.lastName,' ',u.firstName),u.points)  from User u where u.id=:userId")
				.setParameter("userId", userId);
	
		UserProfileModel usr= (UserProfileModel) q.getSingleResult();
		q = em.createQuery("SELECT new fmi.friends.models.ReviewModelUPModel(rev.description,rev.rating,rev.noVotes)  from Review rev "
				+ "inner join rev.user u where u.id=:userId")
				.setParameter("userId", userId);
		List<ReviewModelUPModel> r=  q.getResultList();
		
		q = em.createQuery("SELECT new fmi.friends.models.ItemUPModel(itm.name,itm.price,ord.creationDate)  from Orders ord "
				+ "inner join ord.user u "
				+ "inner join ord.item itm where u.id=:userId")
				.setParameter("userId", userId);
		List<ItemUPModel> i=  q.getResultList();
		tx.commit();
		if(usr!=null){
			usr.setRevList(r);
			usr.setItemList(i);
			return usr;
		}else{
			return null;
		}
	}
	
}
