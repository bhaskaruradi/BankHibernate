package com.capg.bankhibernate.serviceImpl;

import com.capg.bankhibernate.dao.TransactionDao;
import com.capg.bankhibernate.daoImpl.TransationImpl;
import com.capg.bankhibernate.service.ServiceTransaction;
import com.capg.bankhibernate.ui.Customer;
import com.capg.bankhibernate.ui.TransationPojo;

public class ServiceTransactionImpl implements ServiceTransaction {

	  TransactionDao t = new TransationImpl();

		Customer cd = new Customer();

		public Customer deposit(Customer customer) {
			// TODO Auto-generated method stub
			return t.deposit(customer);
		}

		public Customer withDraw(Customer customer) {
			// TODO Auto-generated method stub
			return t.withDraw(customer);
		}

		public Customer showBalance(Customer customer) {
			// TODO Auto-generated method stub
			return t.showBalance(customer);
		}

		public TransationPojo fundTransfer(TransationPojo tp) {
			// TODO Auto-generated method stub
			return t.fundTransfer(tp);
		}



		
}
