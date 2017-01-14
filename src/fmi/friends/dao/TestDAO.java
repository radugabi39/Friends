package fmi.friends.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fmi.friends.hibernateEntities.Item;


public class TestDAO extends GenericDAO {
	
	
	public String getNameById(int empId){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=null;
		if(session.getTransaction()!=null && session.getTransaction().isActive()){
			tx=	session.getTransaction();
		}else{
			tx=session.beginTransaction();
		}
		Item emp = (Item) session.get(Item.class, empId);
		tx.commit();
		return "test";
	}

}
