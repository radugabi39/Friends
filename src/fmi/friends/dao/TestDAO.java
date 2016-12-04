package fmi.friends.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fmi.friends.hibernateEntities.Employee;

public class TestDAO extends GenericDAO {
	
	
	public String getNameById(int empId){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, empId);
		tx.commit();
		return emp.getName();
	}

}
