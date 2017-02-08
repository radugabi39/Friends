package fmi.friends.dao;

import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fmi.friends.hibernateEntities.Item;
import fmi.friends.hibernateEntities.Orders;
import fmi.friends.hibernateEntities.User;
import fmi.friends.models.ItemModel;

public class ItemDAO  extends GenericDAO  {
	
	public List<ItemModel> getItems() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=null;
		if(session.getTransaction()!=null && session.getTransaction().isActive()){
			tx=	session.getTransaction();
		}else{
			tx=session.beginTransaction();
		}	

		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT new fmi.friends.models.ItemModel(i.name,i.description,i.price,i.stock,i.avatarURL,i.id) from Item i");
		List<ItemModel> toReturn = q.getResultList();
		tx.commit();
		return toReturn;
	}
	
	public Boolean buyItem(Integer userID,Integer itemID) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=null;
		if(session.getTransaction()!=null && session.getTransaction().isActive()){
			tx=	session.getTransaction();
		}else{
			tx=session.beginTransaction();
		}	
		try{
			EntityManager em=session.getEntityManagerFactory().createEntityManager();
			User toUpdateUser=session.get(User.class, userID);
			Item it=session.get(Item.class, itemID);
			if(it!=null && toUpdateUser!=null){
				if(it.getPrice().setScale(0,  RoundingMode.HALF_UP).intValue()<toUpdateUser.getPoints()){
					toUpdateUser.setPoints(toUpdateUser.getPoints()-it.getPrice().setScale(0,  RoundingMode.HALF_UP).intValue());
					
					session.save(toUpdateUser);
					
					Orders ord= new Orders();
					ord.setCreationDate(new Date());
					ord.setItem(it);
					ord.setUser(toUpdateUser);
					session.persist(ord);
				
					session.flush();
					tx.commit();
					return true;
				}
			}
		
		}catch(Exception e){
			tx.commit();
			return false;
		}
		tx.commit();
		return false;
	}
	

}
