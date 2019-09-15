package com.capg.bankhibernate.serviceImpl;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.capg.bankhibernate.dao.Welcome;
import com.capg.bankhibernate.daoImpl.WelcomeImpl;
import com.capg.bankhibernate.service.Service;
import com.capg.bankhibernate.ui.Customer;

public class ServiceImpl implements Service {
	  Welcome w = new WelcomeImpl();
	  Customer customer = new Customer();
		
		
		
		public Customer login(Customer customer) {
			return w.login(customer);
			
			
		}

		public boolean isAadharNoCorrect(Object aadharNo) {
			// TODO Auto-generated method stub
			if(((String) aadharNo).length() == 12)
				return true;
			else
				return false;
		}

		public boolean isMobileNoCorrect(String mobileNo) {
			// TODO Auto-generated method stub
			if(mobileNo.length() == 10)
				return true;
			else
				return false;
		}

		public int registration(Customer customer) {
			return w.registration(customer);
		

		
}
}
