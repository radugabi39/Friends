package fmi.friends.dao;
import org.hibernate.SessionFactory;

import fmi.firends.hibernateListener.HibernateUtil;
public class GenericDAO {

	
		protected static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
}
