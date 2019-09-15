package com.capg.bankhibernate.daoImpl;





import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.capg.bankhibernate.dao.Welcome;
import com.capg.bankhibernate.ui.Customer;


public class WelcomeImpl implements Welcome {

	@Override
	public int registration(Customer customer) {
		// TODO Auto-generated method stub
		
		 Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class);
		   SessionFactory sessionFactory = configuration.buildSessionFactory();

		   Session session = sessionFactory.openSession();
		   
		   Transaction transaction = session.beginTransaction();
		  
		   session.persist(customer); 
		   
		   transaction.commit();
		   long accountNumber = 0;
							Query query = session.createQuery("from Customer");
				java.util.List list = query.list();
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					Customer customerDetails1 = (Customer) iterator.next();
					if (customer.getAadharCardNo() == customerDetails1.getAadharCardNo()) {
						accountNumber = customerDetails1.getAccountNo();
					}
				}
				return (int) accountNumber;
		   
		 

		   
		
	}

	@Override
	public Customer login(Customer customer) {
		
		Customer cd  = null;
		 Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class);
		   SessionFactory sessionFactory = configuration.buildSessionFactory();

		   Session session = sessionFactory.openSession();
		   Transaction transaction = session.beginTransaction();
		   Query query = session.createQuery("from Customer");
	        java.util.List list = query.list();
	        for (Iterator iterator = list.iterator(); iterator.hasNext();)
	        {
				Customer customerDetails = (Customer) iterator.next();
				if(customer.getAccountNo() == customerDetails.getAccountNo() &&customer.getPassword().equals(customerDetails.getPassword())) {
					cd = customerDetails;
				}
				
			}
		  
		return cd;
	}

}
	

